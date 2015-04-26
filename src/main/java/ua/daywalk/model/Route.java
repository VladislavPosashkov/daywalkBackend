package ua.daywalk.model;


import javax.persistence.*;


@Entity(name = "dw_route")
@SequenceGenerator(name = "point_generator", sequenceName = "point_id_seq", allocationSize = 1, initialValue = 1)
public class Route {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_generator")
    private Integer id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "title")
    private String title;

    @Column(name = "preview")
    private String preview;

    public Route() {
    }

    public Route(String country, String city, String title, String preview) {
        this.country = country;
        this.city = city;
        this.title = title;
        this.preview = preview;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", title='" + title + '\'' +
                ", preview='" + preview + '\'' +
                '}';
    }
}
