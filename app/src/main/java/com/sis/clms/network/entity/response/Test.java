package com.sis.clms.network.entity.response;

import java.util.List;

/**
 * Created by DELL on 2017/6/5.
 */

public class Test {


    /**
     * body : {"basprddefView":[{"prdname":"个人担保","aflag":"固定提成","flag":"一次性发放","bankid":"000300","bankname":"贷款管理第二中心","term":"成交次日之后0日","gid":"191","score":"3.2","pflag":"固定提成","isself":"0","prdcode":"cs00001","lastdate":"2017-05-10"},{"prdname":"个人联保","aflag":"固定提成","flag":"一次性发放","bankid":"000300","bankname":"贷款管理第二中心","term":"成交次日之后11日","gid":"192","score":"3.2","pflag":"无提成","isself":"0","prdcode":"cs0002","lastdate":"2017-05-10"},{"prdname":"抵押贷款","aflag":"无提成","flag":"按月发放","bankid":"000300","bankname":"贷款管理第二中心","term":"2","gid":"193","score":"3.2","pflag":"固定提成","isself":"0","prdcode":"cs00003","lastdate":"2017-05-10"},{"prdname":"信用","aflag":"固定提成","flag":"按半年发放","bankid":"000300","bankname":"贷款管理第二中心","term":"6","gid":"194","score":"3.2","pflag":"无提成","isself":"0","prdcode":"cs00004","lastdate":"2017-05-10"}]}
     * header : {"rspCode":"000000","rspMsg":"交易执行成功!","serviceCode":"002090"}
     */

    private BodyBean body;
    private HeaderBean header;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public static class BodyBean {
        private List<BasprddefViewBean> basprddefView;

        public List<BasprddefViewBean> getBasprddefView() {
            return basprddefView;
        }

        public void setBasprddefView(List<BasprddefViewBean> basprddefView) {
            this.basprddefView = basprddefView;
        }

        public static class BasprddefViewBean {
            /**
             * prdname : 个人担保
             * aflag : 固定提成
             * flag : 一次性发放
             * bankid : 000300
             * bankname : 贷款管理第二中心
             * term : 成交次日之后0日
             * gid : 191
             * score : 3.2
             * pflag : 固定提成
             * isself : 0
             * prdcode : cs00001
             * lastdate : 2017-05-10
             */

            private String prdname;
            private String aflag;
            private String flag;
            private String bankid;
            private String bankname;
            private String term;
            private String gid;
            private String score;
            private String pflag;
            private String isself;
            private String prdcode;
            private String lastdate;

            public String getPrdname() {
                return prdname;
            }

            public void setPrdname(String prdname) {
                this.prdname = prdname;
            }

            public String getAflag() {
                return aflag;
            }

            public void setAflag(String aflag) {
                this.aflag = aflag;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getBankid() {
                return bankid;
            }

            public void setBankid(String bankid) {
                this.bankid = bankid;
            }

            public String getBankname() {
                return bankname;
            }

            public void setBankname(String bankname) {
                this.bankname = bankname;
            }

            public String getTerm() {
                return term;
            }

            public void setTerm(String term) {
                this.term = term;
            }

            public String getGid() {
                return gid;
            }

            public void setGid(String gid) {
                this.gid = gid;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getPflag() {
                return pflag;
            }

            public void setPflag(String pflag) {
                this.pflag = pflag;
            }

            public String getIsself() {
                return isself;
            }

            public void setIsself(String isself) {
                this.isself = isself;
            }

            public String getPrdcode() {
                return prdcode;
            }

            public void setPrdcode(String prdcode) {
                this.prdcode = prdcode;
            }

            public String getLastdate() {
                return lastdate;
            }

            public void setLastdate(String lastdate) {
                this.lastdate = lastdate;
            }
            @Override
            public String toString() {
                return "prdname:"   +  getPrdname() +
                        "\naflag:"    +getAflag() +
                        "\nflag:"     +getFlag() +
                        "\nbankid:"   +getBankid() +
                        "\nbankname:" +getBankname() +
                        "\nterm:"     +getTerm() +
                        "\ngid:"      +getGid() +
                        "\nscore:"    +getScore() +
                        "\npflag:"    +getPflag() +
                        "\nisself:"   +getIsself() +
                        "\nprdcode:"  +getPrdcode() +
                        "\nlastdate:" +getLastdate() ;
            }
        }

    }

    public static class HeaderBean {
        /**
         * rspCode : 000000
         * rspMsg : 交易执行成功!
         * serviceCode : 002090
         */

        private String rspCode;
        private String rspMsg;
        private String serviceCode;

        public String getRspCode() {
            return rspCode;
        }

        public void setRspCode(String rspCode) {
            this.rspCode = rspCode;
        }

        public String getRspMsg() {
            return rspMsg;
        }

        public void setRspMsg(String rspMsg) {
            this.rspMsg = rspMsg;
        }

        public String getServiceCode() {
            return serviceCode;
        }

        public void setServiceCode(String serviceCode) {
            this.serviceCode = serviceCode;
        }
    }
}
