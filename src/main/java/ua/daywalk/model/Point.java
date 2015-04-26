package ua.daywalk.model;

import javax.persistence.*;


@Entity(name = "dw_point")
@SequenceGenerator(name = "route_generator", sequenceName = "route_id_seq", allocationSize = 1, initialValue = 1)
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_generator")
    private Integer id;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "sequence_number")
    private Integer sequenceNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "info")
    private String info;

    @Column(name = "music_url")
    private String musicUrl;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "angel")
    private Double angle;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", routeId='" + routeId + '\'' +
                ", sequenceNumber=" + sequenceNumber +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", musicUrl='" + musicUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
