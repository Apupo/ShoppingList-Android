package sk.apupo.shoppinglist.daos;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table SHOPPING_LIST_ENTITY.
 */
public class ShoppingListEntity extends BasicEntity  {

    private Long id;
    private String title;
    private String titleClean;
    private String description;
    private java.util.Date modificationDate;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public ShoppingListEntity() {
    }

    public ShoppingListEntity(Long id) {
        this.id = id;
    }

    public ShoppingListEntity(Long id, String title, String titleClean, String description, java.util.Date modificationDate) {
        this.id = id;
        this.title = title;
        this.titleClean = titleClean;
        this.description = description;
        this.modificationDate = modificationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleClean() {
        return titleClean;
    }

    public void setTitleClean(String titleClean) {
        this.titleClean = titleClean;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.util.Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(java.util.Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
