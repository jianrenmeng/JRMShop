package com.qf.pojo;

public class Goods {
    private int gid;//id
    private String gname;//商品名称
    private int stock;//库存
    private String price;//价格
    private int  star;//星星
    private String details;//详细信息
    private int fare;//运费
    private String info;//产品描述
    private int brand_id;// 品牌id 可以为空
    private int isRecommend;//是否被推广
    private int  pic;//图片id
    private int cid;//商品类别id
    private int pid;//图片id
    private String  normalpic;
    private String  detailpic;
    private String smallpic;//可以为空
    private String bigpic;//可以为空
    private String infopic01;//可以为空
    private String infopic02;//可以为空
    private String infopic03;//可以为空
    private String infopic04;//可以为空


    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", stock=" + stock +
                ", price='" + price + '\'' +
                ", star=" + star +
                ", details='" + details + '\'' +
                ", fare=" + fare +
                ", info='" + info + '\'' +
                ", brand_id=" + brand_id +
                ", isRecommend=" + isRecommend +
                ", pic=" + pic +
                ", cid=" + cid +
                ", pid=" + pid +
                ", normalpic='" + normalpic + '\'' +
                ", detailpic='" + detailpic + '\'' +
                ", smallpic='" + smallpic + '\'' +
                ", bigpic='" + bigpic + '\'' +
                ", infopic01='" + infopic01 + '\'' +
                ", infopic02='" + infopic02 + '\'' +
                ", infopic03='" + infopic03 + '\'' +
                ", infopic04='" + infopic04 + '\'' +
                '}';
    }

    public Goods(int gid, String gname, int stock, String price, int star, String details, int fare, String info, int brand_id, int isRecommend, int pic, int cid, int pid, String normalpic, String detailpic, String smallpic, String bigpic, String infopic01, String infopic02, String infopic03, String infopic04) {
        this.gid = gid;
        this.gname = gname;
        this.stock = stock;
        this.price = price;
        this.star = star;
        this.details = details;
        this.fare = fare;
        this.info = info;
        this.brand_id = brand_id;
        this.isRecommend = isRecommend;
        this.pic = pic;
        this.cid = cid;
        this.pid = pid;
        this.normalpic = normalpic;
        this.detailpic = detailpic;
        this.smallpic = smallpic;
        this.bigpic = bigpic;
        this.infopic01 = infopic01;
        this.infopic02 = infopic02;
        this.infopic03 = infopic03;
        this.infopic04 = infopic04;
    }

    public String getDetailpic() {
        return detailpic;
    }

    public void setDetailpic(String detailpic) {
        this.detailpic = detailpic;
    }

    public Goods() {
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getNormalpic() {
        return normalpic;
    }

    public void setNormalpic(String normalpic) {
        this.normalpic = normalpic;
    }

    public String getSmallpic() {
        return smallpic;
    }

    public void setSmallpic(String smallpic) {
        this.smallpic = smallpic;
    }

    public String getBigpic() {
        return bigpic;
    }

    public void setBigpic(String bigpic) {
        this.bigpic = bigpic;
    }

    public String getInfopic01() {
        return infopic01;
    }

    public void setInfopic01(String infopic01) {
        this.infopic01 = infopic01;
    }

    public String getInfopic02() {
        return infopic02;
    }

    public void setInfopic02(String infopic02) {
        this.infopic02 = infopic02;
    }

    public String getInfopic03() {
        return infopic03;
    }

    public void setInfopic03(String infopic03) {
        this.infopic03 = infopic03;
    }

    public String getInfopic04() {
        return infopic04;
    }

    public void setInfopic04(String infopic04) {
        this.infopic04 = infopic04;
    }
}
