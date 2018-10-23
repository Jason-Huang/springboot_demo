package cn.jason.demo;

class Result{
    private String id;
    private String result;
    private String feeAmt;

    public Result(String id, String result, String feeAmt) {
        this.id = id;
        this.result = result;
        this.feeAmt = feeAmt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(String feeAmt) {
        this.feeAmt = feeAmt;
    }
}
