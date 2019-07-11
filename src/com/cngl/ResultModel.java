package com.cngl;

import java.util.List;

public class ResultModel {

    private String domain;
    private String text;
    private List<String> ipAdresses;
    private String submask;
    private String ipAdresses2;


    public static class Builder {

        private String domain;
        private String text;
        private List<String> ipAdresses;
        private String submask;
        private String ipAdresses2;

        public Builder(String domain) {
            this.domain = domain;
        }

        public Builder text(String text) {
            this.text=text;
            return this;
        }

        public Builder ipAdresses(List<String> ipAdresses) {
            this.ipAdresses = ipAdresses;
            return this;
        }

        public Builder submask(String submask) {
            this.submask=submask;
            return this;
        }
        public Builder ipAdresses2(String ipAdresses2) {
            this.ipAdresses2=ipAdresses2;
            return this;
        }

        public ResultModel build() {
            return new ResultModel(this);
        }

    }

    private ResultModel(Builder builder) {
        domain = builder.domain;
        text = builder.text;
        ipAdresses = builder.ipAdresses;
        submask = builder.submask;
        ipAdresses2=builder.ipAdresses2;
    }

}

