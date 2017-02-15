package com.example.hante.thirdopen.mvp.entry.freebook;

import java.io.Serializable;

/**
 * Created By HanTe
 */

public class FreeBookInfo implements Serializable {

    /**
     * data : {"bookImageUrl":"http://img.txt99.cc/Cover/40/40452.jpg","bookName":"盛世嫡宠","bookAuthor":"作者：三则","bookType":"分类：言情小说","bookLength":"字数：752773字","bookProgress":"进度：已完结","bookUpdateTime":"更新：2017-02-14 09:22","bookDownload":"http://www.txt99.cc/home/down/txt/id/40452","bookIntroduction":"&nbsp;&nbsp;&nbsp;&nbsp;身为国公府的嫡长孙女却被人陷害，名誉扫地，最后落得一席粉妆一台小轿从后门入府成为御亲王妾室的下场。 <br> &nbsp;&nbsp;&nbsp;&nbsp;两年后继母所生的妹妹成奕琦嫁入王府成为了王府的女主人。 <br> &nbsp;&nbsp;&nbsp;&nbsp;她告诉她：\u201c你一辈子就该被我踩在脚下！\u201d <br> &nbsp;&nbsp;&nbsp;&nbsp;他告诉她：\u201c你不配怀我的孩子！\u201d <br> &nbsp;&nbsp;&nbsp;&nbsp;重生一世，成奕瑶告诉自己：\u201c上辈子的事我可以当做黄粱一梦，但这辈子绝不再心慈手软，算计我的人一个都不会放过！\u201d"}
     * code : 1
     * requestTime : 2017-02-14 19:58:23
     */

    private DataBean data;
    private int code;
    private String requestTime;

    public DataBean getData () {
        return data;
    }

    public void setData (DataBean data) {
        this.data = data;
    }

    public int getCode () {
        return code;
    }

    public void setCode (int code) {
        this.code = code;
    }

    public String getRequestTime () {
        return requestTime;
    }

    public void setRequestTime (String requestTime) {
        this.requestTime = requestTime;
    }

    public static class DataBean {
        /**
         * bookImageUrl : http://img.txt99.cc/Cover/40/40452.jpg
         * bookName : 盛世嫡宠
         * bookAuthor : 作者：三则
         * bookType : 分类：言情小说
         * bookLength : 字数：752773字
         * bookProgress : 进度：已完结
         * bookUpdateTime : 更新：2017-02-14 09:22
         * bookDownload : http://www.txt99.cc/home/down/txt/id/40452
         * bookIntroduction : &nbsp;&nbsp;&nbsp;&nbsp;身为国公府的嫡长孙女却被人陷害，名誉扫地，最后落得一席粉妆一台小轿从后门入府成为御亲王妾室的下场。 <br> &nbsp;&nbsp;&nbsp;&nbsp;两年后继母所生的妹妹成奕琦嫁入王府成为了王府的女主人。 <br> &nbsp;&nbsp;&nbsp;&nbsp;她告诉她：“你一辈子就该被我踩在脚下！” <br> &nbsp;&nbsp;&nbsp;&nbsp;他告诉她：“你不配怀我的孩子！” <br> &nbsp;&nbsp;&nbsp;&nbsp;重生一世，成奕瑶告诉自己：“上辈子的事我可以当做黄粱一梦，但这辈子绝不再心慈手软，算计我的人一个都不会放过！”
         */

        private String bookImageUrl;
        private String bookName;
        private String bookAuthor;
        private String bookType;
        private String bookLength;
        private String bookProgress;
        private String bookUpdateTime;
        private String bookDownload;
        private String bookIntroduction;

        public String getBookImageUrl () {
            return bookImageUrl;
        }

        public void setBookImageUrl (String bookImageUrl) {
            this.bookImageUrl = bookImageUrl;
        }

        public String getBookName () {
            return bookName;
        }

        public void setBookName (String bookName) {
            this.bookName = bookName;
        }

        public String getBookAuthor () {
            return bookAuthor;
        }

        public void setBookAuthor (String bookAuthor) {
            this.bookAuthor = bookAuthor;
        }

        public String getBookType () {
            return bookType;
        }

        public void setBookType (String bookType) {
            this.bookType = bookType;
        }

        public String getBookLength () {
            return bookLength;
        }

        public void setBookLength (String bookLength) {
            this.bookLength = bookLength;
        }

        public String getBookProgress () {
            return bookProgress;
        }

        public void setBookProgress (String bookProgress) {
            this.bookProgress = bookProgress;
        }

        public String getBookUpdateTime () {
            return bookUpdateTime;
        }

        public void setBookUpdateTime (String bookUpdateTime) {
            this.bookUpdateTime = bookUpdateTime;
        }

        public String getBookDownload () {
            return bookDownload;
        }

        public void setBookDownload (String bookDownload) {
            this.bookDownload = bookDownload;
        }

        public String getBookIntroduction () {
            return bookIntroduction;
        }

        public void setBookIntroduction (String bookIntroduction) {
            this.bookIntroduction = bookIntroduction;
        }
    }

    @Override
    public String toString () {
        return "FreeBookInfo{" +
                "data=" + data +
                ", code=" + code +
                ", requestTime='" + requestTime + '\'' +
                '}';
    }
}
