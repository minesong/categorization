package com.song.classification.svm;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class F1Score {
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
}
