package com.example.hante.thirdopen.mvp.entry.freebook;

import java.io.Serializable;

/**
 * Created By HanTe
 */

public class FreeBookInfo implements Serializable {


    /**
     * data : {"bookImageUrl":"http://img.txt99.cc/Cover/41/41187.jpg","bookName":"医品娘子：夫人，求圆房","bookAuthor":"作者：司药娘子","bookType":"分类：穿越小说","bookLength":"字数：2644761字","bookProgress":"进度：已完结","bookUpdateTime":"更新：2017-04-20 09:10","bookDownload":"http://www.txt99.cc/home/down/txt/id/41187","bookIntroduction":"&nbsp;&nbsp;&nbsp;&nbsp;学医有成，事业得意，一醉穿越成冲喜小新娘！\n<br> &nbsp;&nbsp;&nbsp;&nbsp;什么，要为夫殉葬？有姐在，死不了！\n<br> &nbsp;&nbsp;&nbsp;&nbsp;辣手婆婆，黑心哥嫂，还有老奸巨猾的婆子，美貌娇俏的丫头\u2026各使手段，乱斗心机！\n<br> &nbsp;&nbsp;&nbsp;&nbsp;她一抬手，轻飘飘一句，\u201c无聊！\u201d\n<br> &nbsp;&nbsp;&nbsp;&nbsp;使小计宅门脱身，姐要活的自在恣意！\n<br> &nbsp;&nbsp;&nbsp;&nbsp;万贯家财信手拈来，妖孽型男呼喝来去，捻一杯小酒，听弦歌小曲儿，乐不知归之际，一清秀书生施施然走来\u2014\u2014\n<br> &nbsp;&nbsp;&nbsp;&nbsp;娘子，回家圆房！\n<br> &nbsp;&nbsp;&nbsp;&nbsp;作品标签： 爽文、神医、张扬、女强、炮灰逆袭"}
     * code : 1
     * requestTime : 2017-04-21 20:30:44
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

    @Override
    public String toString () {
        return "FreeBookInfo{" +
                "data=" + data +
                ", code=" + code +
                ", requestTime='" + requestTime + '\'' +
                '}';
    }

    public static class DataBean {
        /**
         * bookImageUrl : http://img.txt99.cc/Cover/41/41187.jpg
         * bookName : 医品娘子：夫人，求圆房
         * bookAuthor : 作者：司药娘子
         * bookType : 分类：穿越小说
         * bookLength : 字数：2644761字
         * bookProgress : 进度：已完结
         * bookUpdateTime : 更新：2017-04-20 09:10
         * bookDownload : http://www.txt99.cc/home/down/txt/id/41187
         * bookIntroduction : &nbsp;&nbsp;&nbsp;&nbsp;学医有成，事业得意，一醉穿越成冲喜小新娘！
         <br> &nbsp;&nbsp;&nbsp;&nbsp;什么，要为夫殉葬？有姐在，死不了！
         <br> &nbsp;&nbsp;&nbsp;&nbsp;辣手婆婆，黑心哥嫂，还有老奸巨猾的婆子，美貌娇俏的丫头…各使手段，乱斗心机！
         <br> &nbsp;&nbsp;&nbsp;&nbsp;她一抬手，轻飘飘一句，“无聊！”
         <br> &nbsp;&nbsp;&nbsp;&nbsp;使小计宅门脱身，姐要活的自在恣意！
         <br> &nbsp;&nbsp;&nbsp;&nbsp;万贯家财信手拈来，妖孽型男呼喝来去，捻一杯小酒，听弦歌小曲儿，乐不知归之际，一清秀书生施施然走来——
         <br> &nbsp;&nbsp;&nbsp;&nbsp;娘子，回家圆房！
         <br> &nbsp;&nbsp;&nbsp;&nbsp;作品标签： 爽文、神医、张扬、女强、炮灰逆袭
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

        @Override
        public String toString () {
            return "DataBean{" +
                    "bookImageUrl='" + bookImageUrl + '\'' +
                    ", bookName='" + bookName + '\'' +
                    ", bookAuthor='" + bookAuthor + '\'' +
                    ", bookType='" + bookType + '\'' +
                    ", bookLength='" + bookLength + '\'' +
                    ", bookProgress='" + bookProgress + '\'' +
                    ", bookUpdateTime='" + bookUpdateTime + '\'' +
                    ", bookDownload='" + bookDownload + '\'' +
                    ", bookIntroduction='" + bookIntroduction + '\'' +
                    '}';
        }
    }
}
