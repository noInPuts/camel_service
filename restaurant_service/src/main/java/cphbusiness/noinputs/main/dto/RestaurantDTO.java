package cphbusiness.noinputs.main.dto;

public class RestaurantDTO {
    private String name;
    private Long id;

    public RestaurantDTO() {
    }

    public RestaurantDTO(String name) {
        this.name = name;
    }

    public RestaurantDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
