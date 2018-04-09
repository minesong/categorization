# categorization
文本分类论文实现代码
>#-*-coding:utf-8-*-
>import matplotlib.pyplot as plt
>from pylab import *                                 #支持中文
>mpl.rcParams['font.sans-serif'] = ['SimHei']
>
>names = ['300','600', '900', '1200','1500', '1800', '2000']
>x = range(len(names))
>y = [75.35,80.96, 82.48, 82.57,81.16, 79.56, 79.00]
>y1= [76.00,81.94, 83.17,  83.76,83.56, 81.74, 79.97]
>y2 = [77.12, 82.54, 84.01, 85.37,85.16, 84.25, 83.50]
>y3 = [80.05, 83.94, 85.01, 86.27,86.46, 85.56, 84.20]
>#plt.plot(x, y, 'ro-')
>#plt.plot(x, y1, 'bo-')
>#pl.xlim(-1, 11)  # 限定横轴的范围
>plt.ylim(70, 90)  # 限定纵轴的范围
>plt.plot(x, y,  marker='o', mfc='w',label=u'E1')
>plt.plot(x, y1, marker='*', ms=10,label=u'E2')
>plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
>plt.plot(x, y3, marker='^' , ms=10,label=u'E4')
>plt.legend()  # 让图例生效
>plt.xticks(x, names, rotation=45)
>plt.margins(0)
>plt.subplots_adjust(bottom=0.15)
>plt.xlabel(u"特征维度") #X轴标签
>plt.ylabel("macro-F1(%)") #Y轴标签
>#plt.title("A simple plot") #标题
>
>plt.show()
>
>plt.show()
>names = ['300','600', '900', '1200','1500', '1800', '2000']
>x = range(len(names))
>y = [73.35,79.96, 82.48, 83.97,84.16, 84.56, 83.00]
>y1= [74.00,82.04, 83.87,  84.76,85.56, 85.74, 84.17]
>y2 = [75.82, 83.54, 85.51, 86.07,87.56, 87.75, 86.95]
>y3 = [79.05, 84.94, 87.01, 88.27,88.46, 89.06, 88.20]
>y4 = [76.21, 81.73,83.96, 84.55, 84.85,85.19, 83.22]
>#plt.plot(x, y, 'ro-')
>#plt.plot(x, y1, 'bo-')
>#pl.xlim(-1, 11)  # 限定横轴的范围
>plt.ylim(70, 90)  # 限定纵轴的范围
>plt.plot(x, y,  marker='o', mfc='w',label=u'E1')
>plt.plot(x, y1, marker='*', ms=10,label=u'E2')
>plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
>plt.plot(x, y3, marker='^' , ms=10,label=u'E4')
>plt.plot(x, y4, marker='<' , ms=10,label=u'E5')
>plt.legend()  # 让图例生效
>plt.xticks(x, names, rotation=45)
>plt.margins(0)
>plt.subplots_adjust(bottom=0.15)
>plt.xlabel(u"特征维度") #X轴标签
>plt.ylabel("macro-F1(%)") #Y轴标签
>#plt.title("A simple plot") #标题
>plt.show()
>
>
>
>
>
>names = ['300','600', '900', '1200','1500', '1800', '2000']
>x = range(len(names))
>y = [72.35,74.96, 75.48, 77.97,78.16,78.56, 77.00]
>y1= [72.47,76.04, 77.87,  78.76,80.56, 79.74, 79.77]
>y2 = [73.82, 79.54, 81.51, 83.07,83.56, 83.95, 82.50]
>y3 = [75.05, 80.94, 82.01, 84.27,84.46, 84.66, 83.90]
>#plt.plot(x, y, 'ro-')
>#plt.plot(x, y1, 'bo-')
>#pl.xlim(-1, 11)  # 限定横轴的范围
>plt.ylim(70, 90)  # 限定纵轴的范围
>plt.plot(x, y,  marker='o', mfc='w',label=u'E1')
>plt.plot(x, y1, marker='*', ms=10,label=u'E2')
>plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
>plt.plot(x, y3, marker='^' , ms=10,label=u'E4')
>plt.legend()  # 让图例生效
>plt.xticks(x, names, rotation=45)
>plt.margins(0)
>plt.subplots_adjust(bottom=0.15)
>plt.xlabel(u"特征维度") #X轴标签
>plt.ylabel("macro-F1(%)") #Y轴标签
>#plt.title("A simple plot") #标题



















#-*-coding:utf-8-*-
import matplotlib.pyplot as plt
from pylab import *                                 #支持中文
mpl.rcParams['font.sans-serif'] = ['SimHei']

names = ['300','700', '1100', '1500','1900', '2300', '2700','3100','3500']
x = range(len(names))


y= [79.67,80.17,81.67, 82.5,  83.5,83.83, 82.83, 81.33,81.17]
y1 = [81.30 ,83.00, 84.17, 85.17,85.17, 85.83, 85.5,84.83,84.00]
y3=[82.33, 85.00, 87.00, 87.33,88.33, 88.67, 88.00,87.66,87.67]
y2 =[82.17, 84.17, 85.33, 87.00,87.00, 88.00, 88.00,87.630,87.33]


#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(78, 90)  # 限定纵轴的范围
plt.plot(x, y,  marker='o', mfc='w',label=u'E1')
plt.plot(x, y1, marker='*', ms=10,label=u'E2')
plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
plt.plot(x, y3, marker='^' , ms=10,label=u'E4')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=45)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度") #X轴标签
plt.ylabel("accuracy(%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()

names = ['300','600', '900', '1200','1500', '1800', '2000']
x = range(len(names))
y= [79.87,81.45, 82.76,  83.09,82.33, 83.47, 83.33]
y1 = [80.45 ,83.66,  84.31,84.61,85.47, 85.18, 84.08]
y2=[81.76, 84.90, 85.06, 85.32,85.54, 85.09, 85.09]
y3 =[83.66, 85.18,85.99, 86.14,86.41, 85.76, 86.02]


#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(79, 87)  # 限定纵轴的范围
plt.plot(x, y,  marker='o', mfc='w',label=u'E1')
plt.plot(x, y1, marker='*', ms=10,label=u'E2')
plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
plt.plot(x, y3, marker='^' , ms=10,label=u'E4')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=45)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度") #X轴标签
plt.ylabel("accuracy(%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()





#-*-coding:utf-8-*-
import matplotlib.pyplot as plt
from pylab import *  
from matplotlib.font_manager import FontProperties
custom_font = FontProperties(fname=r'C:\\WINDOWS\\Fonts\\simsun.ttc') 
#mpl.rcParams['font.sans-serif'] = ["Microsoft JhengHei"]
mpl.rcParams['font.size'] = 12  
plt.rcParams['axes.unicode_minus'] = False
names = ['300','600', '900', '1200','1500', '1800', '2000']
x = range(len(names))
y = [74.67,78.44, 81.02, 81.53,82.37, 82.29, 82.20]
y1 = [75.95, 79.83,81.08, 82.95, 83.83,83.19, 82.82]
y2= [78.00,80.04, 82.27,  84.33,84.26, 84.00, 84.17]
y3 = [79.82, 81.54, 84.31, 85.07,86.66, 86.195, 85.95]
y4 = [80.15, 82.94, 84.71, 86.77,87.45, 87.06, 86.80]

#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(74, 88)  # 限定纵轴的范围
plt.plot(x, y,  marker='o',color ='black', mfc='w',label=u'E1')
plt.plot(x, y1, marker='<' , color ='black',ms=10,label=u'E2')
plt.plot(x, y2, marker='*',color ='black', ms=10,label=u'E3')
plt.plot(x, y3, marker='+',color ='black',  ms=10,label=u'E4')
plt.plot(x, y4, marker='^' ,color ='black', ms=10,label=u'E5')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度/个") #X轴标签
plt.ylabel("macro-F1 (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()
names = [u'汽车',u'文化', u'经济', u'医药',u'军事', u'体育']
x = range(len(names))
y = [86.52,	72.37	,88.89	,83.97,	72.94,	75.22]
y1 = [86.19,	77.52,	89.50,	85.57,	73.62,	80.212]
y2= [87.24	,77.85	,90.81	,86.43	,73.83,	81.85]
y3 = [91.98	,78.50,	93.20	,87.37,	81.11,	83.84]
y4 = [92.04	,80.18,	93.88	,87.94,	82.29,	84.59]

#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(70, 95)  # 限定纵轴的范围
plt.plot(x, y,  marker='o',color ='black', ms=10,label=u'E1')
plt.plot(x, y1, marker='<' ,color ='black', ms=10,label=u'E2')
plt.plot(x, y2, marker='*',color ='black', ms=10,label=u'E3')
plt.plot(x, y3, marker='+', color ='black', ms=10,label=u'E4')
plt.plot(x, y4, marker='^' ,color ='black', ms=10,label=u'E5')

plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度") #X轴标签
plt.ylabel("macro-F1(%)") #Y轴标签
#plt.title("A simple plot") #标题
plt.show()

	#汽车	文化	经济	医药	军事	体育
#E1	86.52	72.37	88.89	83.97	72.94.	75.22
#E2	86.19	77.52	89.50	85.57	73.62	80.21
#E3	87.24	77.85	90.81	86.43	73.83	81.85
#E4	91.98	78.50	93.20	87.37	81.11	83.84
#E5	92.04	80.18.	93.88	87.94	82.29	84.59

names = ['500','1000', '1500', '2000','2500', '3000', '3500']
x = range(len(names))
y = [77.02,79.17, 80.02, 80.83,81.93, 80.99, 80.20]
y1 = [77.85, 80.25,81.48, 81.95, 82.43,81.88, 81.42]
y2=    [78.00,81.04, 83.29,  84.13,84.84, 84.1, 83.57]
y3 = [78.82, 82.04, 84.31, 84.87,85.33, 85.15, 84.95]
y4 = [79.15, 83.64, 84.51, 85.27,86.25, 86.06, 85.80]

#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(77, 90.5)  # 限定纵轴的范围
plt.plot(x, y,  marker='o',color ='black', mfc='w',label=u'E1')
plt.plot(x, y1, marker='<' , color ='black',ms=10,label=u'E2')
plt.plot(x, y2, marker='*', color ='black',ms=10,label=u'E3')
plt.plot(x, y3, marker='+', color ='black', ms=10,label=u'E4')
plt.plot(x, y4, marker='^' ,color ='black', ms=10,label=u'E5')

plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度/个") #X轴标签
plt.ylabel("macro-F1(%)") #Y轴标签
#plt.title("A simple plot") #标题
plt.show()


names = ['500','1000', '1500', '2000','2500', '3000', '3500']
x = range(len(names))
y = [78.02,79.17, 80.02, 80.83,81.93, 80.99, 80.20]
y1 = [77.85, 80.25,81.48, 81.95, 82.43,81.88, 81.42]
y2=    [78.00,81.04, 83.29,  84.13,84.84, 84.1, 83.57]
y3 = [78.82, 82.04, 84.31, 84.87,85.33, 85.15, 84.95]
y4 = [79.15, 83.64, 84.51, 85.27,86.25, 86.06, 85.80]

#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(70, 90)  # 限定纵轴的范围
plt.plot(x, y,  marker='o',color ='black', mfc='w',label=u'E1')
plt.plot(x, y1, marker='<' ,color ='black', ms=10,label=u'E2')
plt.plot(x, y2, marker='*',color ='black', ms=10,label=u'E3')
plt.plot(x, y3, marker='+', color ='black', ms=10,label=u'E4')
plt.plot(x, y4, marker='^' , color ='black',ms=10,label=u'E5')

plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=45)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度") #X轴标签
plt.ylabel("macro-F1 (%)") #Y轴标签
#plt.title("A simple plot") #标题
plt.show()
names = ['500','1000', '1500', '2000','2500', '3000', '3500']
x = range(len(names))
y = [79.15,80.91, 81.53, 82.52, 83.28,83.47, 83.12]
y1 = [79.25, 81.25,81.98, 82.85, 84.38,84.43, 84.02]
y2=    [80.00,82.84, 83.79,  84.77,84.79, 84.61, 84.57]
y3 = [81.82, 83.04, 84.21, 85.62, 85.75,85.83, 85.55]
y4 = [82.15, 84.34, 85.51, 86.27,86.75, 86.86, 86.80]

#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(78, 88)  # 限定纵轴的范围
plt.plot(x, y,  marker='o', color ='black',mfc='w',label=u'E1')
plt.plot(x, y1, marker='<' ,color ='black', ms=10,label=u'E2')
plt.plot(x, y2, marker='*',color ='black', ms=10,label=u'E3')
plt.plot(x, y3, marker='+', color ='black', ms=10,label=u'E4')
plt.plot(x, y4, marker='^' , color ='black',ms=10,label=u'E5')

plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度/个") #X轴标签
plt.ylabel("macro-F1 (%)") #Y轴标签
#plt.title("A simple plot") #标题
plt.show()






#-*-coding:utf-8-*-
import matplotlib.pyplot as plt
from pylab import *                                 #支持中文
mpl.rcParams['font.sans-serif'] = ['SimHei']

names = ['300','900', '1500', '2100','2700', '3300', '3900']
x = range(len(names))
# 0.0, 0.8881118881118881, 3.0, 0.9878048780487805, 1.0, 0.9402985074626866, 6.0, 0.6320754716981132, 5.0, 0.9701492537313433, 2.0, 0.7709251101321586, 7.0, 0.9699248120300752, 4.0, 0.6645962732919255, 0.8328584995251662,
y = [79.77,81.76, 80.62, 83.28,83.18, 81.05, 82.90]
#0.0, 0.916083916083916, 3.0, 1.0, 1.0, 0.9402985074626866, 6.0, 0.6415094339622641, 5.0, 1.0, 2.0, 0.8193832599118943, 7.0, 0.9624060150375939, 4.0, 0.6335403726708074, 0.8452041785375118,
y1= [77.87,82.71, 84.23,  84.52,82.67, 83.09, 82.62]
#0.0, 0.8951048951048951, 3.0, 1.0, 1.0, 0.9402985074626866, 6.0, 0.5566037735849056, 5.0, 0.9701492537313433, 2.0, 0.8546255506607929, 7.0, 0.9548872180451128, 4.0, 0.7080745341614907, 0.8499525166191833,
y2 = [80.62, 82.03, 85.66, 85.00,85.84, 85.57, 84.90]
# 0.0, 0.916083916083916, 3.0, 0.9878048780487805, 1.0, 0.9402985074626866, 6.0, 0.660377358490566, 5.0, 0.9701492537313433, 2.0, 0.8678414096916299, 7.0, 0.9548872180451128, 4.0, 0.7204968944099379, 0.8670465337132004,
y3 = [79.19, 83.46, 86.42, 86.70,85.66, 86.33, 85.57]
#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(77, 88)  # 限定纵轴的范围
plt.plot(x, y,  marker='o', mfc='w',label=u'E1')
plt.plot(x, y1, marker='*', ms=10,label=u'E2')
plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
plt.plot(x, y3, marker='^' , ms=10,label=u'E4')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度") #X轴标签
plt.ylabel("accuracy (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()
#E1	88.81	92.53	77.97	98.78	66.46	97.01	63.21	96.99
#E2	89.51	94.03	83.26	95.12	67.70	95.52	64.15	96.24
#E3	90.21	93.28	83.70	96.34	70.81	94.03	64.15	95.49
#E4	91.61	94.77	86.78	98.78	72.05	97.01	66.04	95.49
names = [u'农业',u'经济', u'政治', u'艺术',u'运动', u'医药', u'环境',u'空间']
x = range(len(names))
y = [88.81,	92.53,	77.97,	98.78,	66.46,	97.01,	63.21,	96.99]
y1= [89.51,	94.03,	83.26,	95.12,	67.70,	95.52,	64.15,	96.24]
y2 = [90.21	,93.28,	83.70,	96.34,	70.81,	94.03,	64.15,	95.49]
y3 = [91.61	,94.77,	86.78,	98.78,	72.05,	97.01,	66.04,	95.49]
#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(60, 100)  # 限定纵轴的范围
plt.plot(x, y,  marker='o', mfc='w',label=u'E1')
plt.plot(x, y1, marker='*', ms=10,label=u'E2')
plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
plt.plot(x, y3, marker='^' , ms=10,label=u'E4')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"类别") #X轴标签
plt.ylabel("accuracy (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()
























#-*-coding:utf-8-*-
import matplotlib.pyplot as plt
from pylab import *  
from matplotlib.font_manager import FontProperties
custom_font = FontProperties(fname=r'C:\\WINDOWS\\Fonts\\simsun.ttc') 
#mpl.rcParams['font.sans-serif'] = ["Microsoft JhengHei"]
mpl.rcParams['font.size'] = 15
names = ['300','900', '1500', '2100','2700', '3300', '3900']
x = range(len(names))
y1 = [75.29,80.33, 79.53, 80.52,79.41, 78.58, 77.54]
y=   [72.82,76.84, 74.81, 77.81,73.66, 71.90, 71.11]
#y2 = [85.33, 84.34, 83.41, 80.49,80.61, 85.57, 71.56]
y2 = [75.43,79.52,  81.11,83.53,81.94, 80.12, 79.57]
#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(70, 85)  # 限定纵轴的范围
plt.plot(x, y, color ='black', marker='o', mfc='w',label=u'E1')
plt.plot(x, y1,color ='black', marker='*', ms=10,label=u'E2')
#plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
plt.plot(x, y2,color ='black', marker='^' , ms=10,label=u'E3')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度/个") #X轴标签
plt.ylabel("macro_F1 (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()
names = [u'农业',u'艺术', u'空间', u'医药',u'体育', u'经济', u'政治',u'环境']
x = range(len(names))
y1 =[82.66,	91.56,	62.83,	70.40,80.36,	85.23,	65.69,	81.22]
y=  [80.87,	85.71,	60.26,	62.93,	72.38,	85.37,	63.75,	83.62]
y2 =[91.67	,88.61,70.01,	79.99,	76.11,	83.46,	77.65,	90.40]
#y3 = [91.61	,94.77,	86.78,	98.78,	72.05,	97.01,	66.04,	95.49]
#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(60, 100)  # 限定纵轴的范围
plt.plot(x, y,  color ='black',marker='o', mfc='w',label=u'E1')
plt.plot(x, y1, color ='black',marker='*', ms=10,label=u'E2')
plt.plot(x, y2, color ='black',marker='^',  ms=10,label=u'E3')
#plt.plot(x, y3, marker='^' , ms=10,label=u'E4')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"类别") #X轴标签
plt.ylabel(u"F1值 (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()

names = ['300','600', '900', '1200','1500', '1800', '2000']
x = range(len(names))
y2=   [74.86,79.59, 82.24, 82.87, 83.52,82.80, 82.27]
y1 = [76.54,78.19, 80.10,80.52,  81.28,80.92, 79.72]
#y2 = [85.33, 84.34, 83.41, 80.49,80.61, 85.57, 71.56]
y = [75.52,77.60,  79.04,78.94,80.28, 79.74, 79.36]
#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(70, 85)  # 限定纵轴的范围
plt.plot(x, y,  color ='black',marker='o', mfc='w',label=u'E1')
plt.plot(x, y1, color ='black',marker='*', ms=10,label=u'E2')
#plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
plt.plot(x, y2, color ='black',marker='^' , ms=10,label=u'E3')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度/个") #X轴标签
plt.ylabel("macro_F1 (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()
names = [u'汽车',u'文化', u'经济', u'医药',u'军事', u'运动']
x = range(len(names))
y=  [86.03,	58.57,	86.15,	57.75,	84.49,	86.36]
y1 =[84.57,	65.93,	83.84,	68.83,82.65,	86.36]

y2 =[88.65	,67.86,87.68,	72.96,	83.05,	88.71]
#y3 = [91.61	,94.77,	86.78,	98.78,	72.05,	97.01,	66.04,	95.49]
#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(57, 92)  # 限定纵轴的范围
plt.plot(x, y,  color ='black',marker='o', mfc='w',label=u'E1')
plt.plot(x, y1, color ='black',marker='*', ms=10,label=u'E2')
plt.plot(x, y2,color ='black', marker='^',  ms=10,label=u'E3')
#plt.plot(x, y3, marker='^' , ms=10,label=u'E4')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"类别") #X轴标签
plt.ylabel(u"F1值 (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()
names = ['300','600', '900', '1200','1500', '1800', '2000']
x = range(len(names))
#y2 = [85.33, 84.34, 83.41, 80.49,80.61, 85.57, 71.56]
y = [75.96,79.10,  75.35,78.72,78.67, 75.82, 75.46]
y1 = [77.82,80.18, 79.69,80.41,  79.39,76.72, 75.92]
y2=   [77.46,78.87, 82.91, 84.38, 82.98,77.46, 77.26]
#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(70, 90)  # 限定纵轴的范围
plt.plot(x, y,  color ='black',marker='o', mfc='w',label=u'E1')
plt.plot(x, y1, color ='black',marker='*', ms=10,label=u'E2')
#plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
plt.plot(x, y2,color ='black', marker='^' , ms=10,label=u'E3')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度/个") #X轴标签
plt.ylabel("macro_F1 (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()
names = [u'汽车',u'文化', u'经济', u'医药',u'军事', u'运动']
x = range(len(names))
y=  [86.03,	58.57,	86.15,	57.75,	84.49,	86.36]
y1 =[84.57,	65.93,	83.84,	68.83,82.65,	86.36]

y2 =[88.65	,67.86,87.68,	72.96,	83.05,	88.71]
#y3 = [91.61	,94.77,	86.78,	98.78,	72.05,	97.01,	66.04,	95.49]
#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(57, 92)  # 限定纵轴的范围
plt.plot(x, y, color ='black', marker='o', mfc='w',label=u'E1')
plt.plot(x, y1, color ='black',marker='*', ms=10,label=u'E2')
plt.plot(x, y2,color ='black', marker='^',  ms=10,label=u'E3')
#plt.plot(x, y3, marker='^' , ms=10,label=u'E4')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"类别") #X轴标签
plt.ylabel(u"F1值 (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()

names = ['300','700', '900', '1100','1300', '1700', '2000']
x = range(len(names))
y =   [86.45,87.87, 82.91, 84.38, 83.58, 77.46, 77.26]
y1 =  [86.23,87.87, 84.17, 83.43, 84.53, 74.59, 75.42]
y2=   [86.07,87.92, 83.53, 83.66, 84.31, 74.37, 76.29]
y3=   [86.12,89.22, 84.19, 83.39, 83.23, 76.85, 76.67]
y4=   [86.26,88.85, 83.57, 83.49, 83.46, 76.82, 76.29]
y5=   [85.86,84.75, 84.42, 83.22, 84.13, 76.19, 76.46]
#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(70, 90)  # 限定纵轴的范围
plt.plot(x, y, marker='o', mfc='w',label=u'E1')
plt.plot(x, y1,marker='*', ms=10,label=u'E2')

plt.plot(x, y2, marker='^' , ms=10,label=u'E3')
plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
plt.plot(x, y2, marker='>',  ms=10,label=u'E3')
plt.plot(x, y2, marker='<',  ms=10,label=u'E3')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度/个") #X轴标签
plt.ylabel("macro_F1 (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()

names = ['300','700', '900', '1100','1300', '1700', '2000']
x = range(len(names))
y =   [88.52,87.61, 82.60, 83.61, 81.94, 79.79, 80.28]
y1 =  [88.02,84.59, 81.62, 81.11, 81.93, 80.06, 79.01]
y2=   [87.99,84.66, 82.15, 80.68, 81.65, 80.39, 79.15]
y3=   [88.15,84.96, 83.33, 80.45, 81.50, 80.71, 79.09]
y4=   [88.02,84.67, 82.45, 79.64, 81.59, 80.47, 79.42]
y5=   [87.50,84.85, 81.97, 79.53, 81.63, 80.56, 79.09]
#plt.plot(x, y, 'ro-')
#plt.plot(x, y1, 'bo-')
#pl.xlim(-1, 11)  # 限定横轴的范围
plt.ylim(70, 90)  # 限定纵轴的范围
plt.plot(x, y, marker='o', mfc='w',label=u'E1')
plt.plot(x, y1,marker='*', ms=10,label=u'E2')

plt.plot(x, y2, marker='^' , ms=10,label=u'E3')
plt.plot(x, y2, marker='+',  ms=10,label=u'E3')
plt.plot(x, y2, marker='>',  ms=10,label=u'E3')
plt.plot(x, y2, marker='<',  ms=10,label=u'E3')
plt.legend()  # 让图例生效
plt.xticks(x, names, rotation=0)
plt.margins(0)
plt.subplots_adjust(bottom=0.15)
plt.xlabel(u"特征维度/个") #X轴标签
plt.ylabel("macro_F1 (%)") #Y轴标签
#plt.title("A simple plot") #标题

plt.show()
