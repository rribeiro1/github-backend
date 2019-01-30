package com.vanhack.github.domain;

import java.sql.Timestamp;

public class Error {

    private String message;
    private String details;
    private Timestamp timestamp;

    private Error(Builder builder) {
        this.message = builder.message;
        this.details = builder.details;
        this.timestamp = builder.timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    protected Error() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String message;
        private String details;
        private Timestamp timestamp;

        private Builder() {}

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withDetails(String details) {
            this.details = details;
            return this;
        }

        public Builder withTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Error build() {
            return new Error(this);
        }
    }

}
