package com.song.classification.svm;

import libsvm.*;

import java.io.*;
import java.util.*;

/*class F1Score {
    public Double p;
    public Double r;
    public Double f;

    public F1Score(Double p, Double r, Double f) {
        this.p = p;
        this.r = r;
        this.f = f;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }
}*/

public class svm_predict {
    public static List<F1Score> f1Scores;
    public static double micro;
    public static double macro;
    public static StringBuffer buffer = new StringBuffer();
    public static List<Double> targetlist = new ArrayList<>();
    public static List<Double> vtlist = new ArrayList<>();
    private static svm_print_interface svm_print_null = new svm_print_interface() {
        public void print(String s) {
        }
    };

    private static svm_print_interface svm_print_stdout = new svm_print_interface() {
        public void print(String s) {
            System.out.print(s);
        }
    };

    private static svm_print_interface svm_print_string = svm_print_stdout;

    static void info(String s) {
        svm_print_string.print(s);
    }

    private static double atof(String s) {
        return Double.valueOf(s).doubleValue();
    }

    private static int atoi(String s) {
        return Integer.parseInt(s);
    }

    private static void predict(BufferedReader input, DataOutputStream output, svm_model model, int predict_probability)
            throws IOException {
        f1Scores = new ArrayList<>();
        targetlist = new ArrayList<>();
        vtlist = new ArrayList<>();
        int correct = 0;
        int total = 0;
        double error = 0;
        double sumv = 0, sumy = 0, sumvv = 0, sumyy = 0, sumvy = 0;

        int svm_type = svm.svm_get_svm_type(model);
        int nr_class = svm.svm_get_nr_class(model);
        double[] prob_estimates = null;

        if (predict_probability == 1) {
            if (svm_type == svm_parameter.EPSILON_SVR || svm_type == svm_parameter.NU_SVR) {
                svm_predict.info(
                        "Prob. model for test data: target value = predicted value + z,\nz: Laplace distribution e^(-|z|/sigma)/(2sigma),sigma="
                                + svm.svm_get_svr_probability(model) + "\n");
            } else {
                int[] labels = new int[nr_class];
                svm.svm_get_labels(model, labels);
                prob_estimates = new double[nr_class];
                output.writeBytes("labels");
                for (int j = 0; j < nr_class; j++)
                    output.writeBytes(" " + labels[j]);
                output.writeBytes("\n");
            }
        }
        while (true) {
            String line = input.readLine();
            if (line == null)
                break;

            StringTokenizer st = new StringTokenizer(line, " \t\n\r\f:");

            double target = atof(st.nextToken());
            int m = st.countTokens() / 2;
            svm_node[] x = new svm_node[m];
            for (int j = 0; j < m; j++) {
                x[j] = new svm_node();
                x[j].index = atoi(st.nextToken());
                x[j].value = atof(st.nextToken());
            }

            double v;
            if (predict_probability == 1 && (svm_type == svm_parameter.C_SVC || svm_type == svm_parameter.NU_SVC)) {
                v = svm.svm_predict_probability(model, x, prob_estimates);
                output.writeBytes(v + " ");
                for (int j = 0; j < nr_class; j++)
                    output.writeBytes(prob_estimates[j] + " ");
                output.writeBytes("\n");
            } else {
                v = svm.svm_predict(model, x);
                output.writeBytes(v + "\n");
            }
            targetlist.add(target);
            vtlist.add(v);
            if (v == target)
                ++correct;
            error += (v - target) * (v - target);
            sumv += v;
            sumy += target;
            sumvv += v * v;
            sumyy += target * target;
            sumvy += v * target;
            ++total;
        }
        if (svm_type == svm_parameter.EPSILON_SVR || svm_type == svm_parameter.NU_SVR) {
            svm_predict.info("Mean squared error = " + error / total + " (regression)\n");
            svm_predict
                    .info("Squared correlation coefficient = "
                            + ((total * sumvy - sumv * sumy) * (total * sumvy - sumv * sumy))
                            / ((total * sumvv - sumv * sumv) * (total * sumyy - sumy * sumy))
                            + " (regression)\n");
        } else {
            svm_predict.info("Accuracy = " + (double) correct / total * 100 + "% (" + correct + "/" + total
                    + ") (classification)\n");
            Set<Double> set = new HashSet<>();
            set.addAll(targetlist);
            double t = 0.0;
            int pp = 0;
            int rr = 0;
            int nn = 0;
            double mpp = 0;
            double mrr = 0;
            double mnn = 0;
            for (Double d : set) {
                int n = 0;
                for (int i = 0; i < targetlist.size(); i++) {
                    if (targetlist.get(i).equals(d) && targetlist.get(i).equals(vtlist.get(i))) {
                        n++;
                    }

                }
                int p = 0;
                for (Double num : targetlist) {
                    if (num.equals(d)) {
                        p++;
                    }
                }
                int r = 0;
                for (Double num : vtlist) {
                    if (num.equals(d)) {
                        r++;
                    }
                }
                pp += p;
                rr += r;
                nn += n;
                mpp += n * 1.0 / p;
                mrr += n * 1.0 / r;
                f1Scores.add(
                        new F1Score(n * 1.0 / p, n * 1.0 / r, (2.0 * n / p * n / r) / (n * 1.0 / p + n * 1.0 / r)));
            }

            System.out.println("evalute");
            System.out.println(f1Scores);

            System.out.println("micro: " + 2.0 * nn / pp * nn / rr / (nn * 1.0 / pp + nn * 1.0 / rr));
            System.out.println("macro: " + (2.0 * mpp * mrr) / f1Scores.size() / (mpp * 1.0 + mrr));
            micro = 2.0 * nn / pp * nn / rr / (nn * 1.0 / pp + nn * 1.0 / rr);
            macro = (2.0 * mpp * mrr) / f1Scores.size() / (mpp * 1.0 + mrr);
        }
    }

    private static void exit_with_help() {
        System.err.print("usage: svm_predict [options] test_file model_file output_file\n" + "options:\n"
                + "-b probability_estimates: whether to predict probability estimates, 0 or 1 (default 0); one-class SVM not supported yet\n"
                + "-q : quiet mode (no outputs)\n");
        System.exit(1);
    }

    public static void main(String argv[]) throws IOException {
        int i, predict_probability = 0;
        svm_print_string = svm_print_stdout;

        // parse options
        for (i = 0; i < argv.length; i++) {
            if (argv[i].charAt(0) != '-')
                break;
            ++i;
            switch (argv[i - 1].charAt(1)) {
                case 'b':
                    predict_probability = atoi(argv[i]);
                    break;
                case 'q':
                    svm_print_string = svm_print_null;
                    i--;
                    break;
                default:
                    System.err.print("Unknown option: " + argv[i - 1] + "\n");
                    exit_with_help();
            }
        }
        if (i >= argv.length - 2)
            exit_with_help();
        try {
            BufferedReader input = new BufferedReader(new FileReader(argv[i]));
            DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(argv[i + 2])));
            svm_model model = svm.svm_load_model(argv[i + 1]);
            if (model == null) {
                System.err.print("can't open model file " + argv[i + 1] + "\n");
                System.exit(1);
            }
            if (predict_probability == 1) {
                if (svm.svm_check_probability_model(model) == 0) {
                    System.err.print("Model does not support probabiliy estimates\n");
                    System.exit(1);
                }
            } else {
                if (svm.svm_check_probability_model(model) != 0) {
                    svm_predict.info("Model supports probability estimates, but disabled in prediction.\n");
                }
            }
            predict(input, output, model, predict_probability);
            input.close();
            output.close();
        } catch (FileNotFoundException e) {
            exit_with_help();
        } catch (ArrayIndexOutOfBoundsException e) {
            exit_with_help();
        }
    }

    public static void writeStrToFile(String path, String c) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            Writer os = new OutputStreamWriter(fos, "utf-8");
            os.write(c);
            os.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
