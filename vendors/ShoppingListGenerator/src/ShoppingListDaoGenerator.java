import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class ShoppingListDaoGenerator {
	
	private static Entity 	basic, product, category, shoppinglist;

	private static final String SHOPPING_LIST_GENERATE_PATH					=				"../ShoppingList/src";
	private static final String SHOPPING_LIST_PREPARED_GENERATE_PATH		=				"../ShoppingListPrepared/src";
	
	public static void main(String[] args) throws Exception {
		
		Schema schema = new Schema(1, "sk.apupo.shoppinglist.daos");
		schema.enableKeepSectionsByDefault();
		
		addBasic(schema);
		addProduct(schema);
		addCategory(schema);
		addShoppingList(schema);
		
		addRelationships(schema);
		
		new DaoGenerator().generateAll(schema, SHOPPING_LIST_PREPARED_GENERATE_PATH);
	}
	
	private static void addBasic(Schema schema) {
		basic = schema.addEntity("BasicEntity");
		
		//basic.addIntProperty("modificationDate");		
		basic.addBooleanProperty("deletedLogical");
		
	}
	
	private static void addProduct(Schema schema) {
		product = schema.addEntity("ProductEntity");
		product.setSuperclass("BasicEntity");
		product.addIdProperty().index().primaryKey().autoincrement();
		
		product = schema.addEntity("Product");
		product.addStringProperty("title");
		product.addStringProperty("description");
		product.addFloatProperty("unitPrice");
		product.addBooleanProperty("bought");
		product.addDateProperty("boughtDate");
		product.addDateProperty("modificationDate");
		product.addStringProperty("titleClean");
		product.addBooleanProperty("inBasket");
		product.addIntProperty("quantity");
		product.addIntProperty("quantityType");
	}
	
	private static void addCategory(Schema schema) {
		category = schema.addEntity("CategoryEntity");
		category.setSuperclass("BasicEntity");
		category.addIdProperty().index().primaryKey().autoincrement();
		
		category.addStringProperty("title");
		category.addStringProperty("titleClean");
		category.addStringProperty("description");
		category.addIntProperty("color");
	}
	
	private static void addShoppingList(Schema schema) {
		shoppinglist = schema.addEntity("ShoppingListEntity");
		shoppinglist.setSuperclass("BasicEntity");
		shoppinglist.addIdProperty().index().primaryKey().autoincrement();
		
		shoppinglist.addStringProperty("title");
		shoppinglist.addStringProperty("description");
		shoppinglist.addDateProperty("modificationDate");
		shoppinglist.addStringProperty("titleClean");
		shoppinglist.addDateProperty("boughtDate");
	}
	
	private static void addRelationships(Schema schema) {
		
		Property categoryIdProperty = product.addLongProperty("fk_category_id").notNull().getProperty();
		product.addToOne(category, categoryIdProperty);

		ToMany productsToCategory = category.addToMany(product, categoryIdProperty);
		productsToCategory.setName("products");
		
		/*
		//show to many episode
		Property showIdProperty = episode.addLongProperty("fk_show_id").notNull().getProperty();
		episode.addToOne(show, showIdProperty);
		
		ToMany showsToEpisodes = show.addToMany(episode, showIdProperty);
		showsToEpisodes.setName("episodes");
		
		//show to many programs
		showIdProperty = program.addLongProperty("fk_show_id").notNull().getProperty();
		program.addToOne(show, showIdProperty);
		
		ToMany showsToPrograms = show.addToMany(program, showIdProperty);
		showsToPrograms.setName("programs");
		
		//show to many promos
		showIdProperty = promo.addLongProperty("fk_show_id").notNull().getProperty();
		promo.addToOne(show, showIdProperty);
		
		ToMany showsToPromos = show.addToMany(promo, showIdProperty);
		showsToPromos.setName("promos");
		
		//television to many shows
		Property televisionIdProperty = show.addLongProperty("fk_television_id").notNull().getProperty();
		show.addToOne(television, televisionIdProperty);
		
		ToMany televisionsToShows = television.addToMany(show, televisionIdProperty);
		televisionsToShows.setName("shows");

		//television to many episodes
		//televisionIdProperty = episode.addLongProperty("fk_television_id").notNull().getProperty();
		//episode.addToOne(television, televisionIdProperty);
		
		//ToMany televisionsToEpisodes = television.addToMany(episode, televisionIdProperty);
		//televisionsToEpisodes.setName("episodes");
		
		//television to many mostViewedEpisodes
		televisionIdProperty = episode.addLongProperty("fk_mostViewedTelevision_id").notNull().getProperty();
		episode.addToOne(television, televisionIdProperty, "mostViewedTelevision");
		
		ToMany televisionsToMostViewedTelevisions = television.addToMany(episode, televisionIdProperty);
		televisionsToMostViewedTelevisions.setName("mostViewedEpisodes");

		//television to many galeries
		televisionIdProperty = gallery.addLongProperty("fk_television_id").notNull().getProperty();
		gallery.addToOne(television, televisionIdProperty);
		
		ToMany televisionsToGalleries = television.addToMany(gallery, televisionIdProperty);
		televisionsToGalleries.setName("galeries");
		
		//television to many programs
		televisionIdProperty = program.addLongProperty("fk_television_id").notNull().getProperty();
		program.addToOne(television, televisionIdProperty);
		
		ToMany televisionsToPrograms = television.addToMany(program, televisionIdProperty);
		televisionsToPrograms.setName("programs");
		
		//television to many promos
		televisionIdProperty = promo.addLongProperty("fk_television_id").notNull().getProperty();
		promo.addToOne(television, televisionIdProperty);
		
		ToMany televisionsToPromos = television.addToMany(promo, televisionIdProperty);
		televisionsToPromos.setName("promos");
		
		//episode to many promos
		Property episodeIdProperty = promo.addLongProperty("fk_episode_id").notNull().getProperty();
		promo.addToOne(episode, episodeIdProperty);
		
		ToMany episodesToPromos = episode.addToMany(promo, episodeIdProperty);
		episodesToPromos.setName("promos");
		
		//gallery to many galleryimages
		Property galleryIdProperty = galleryImage.addLongProperty("fk_gallery_id").notNull().getProperty();
		galleryImage.addToOne(gallery, galleryIdProperty);
		
		ToMany galleriesToImages = gallery.addToMany(galleryImage, galleryIdProperty);
		galleriesToImages.setName("images");
		
		//episode to one recomendedepisode
		episodeIdProperty = recommandedEpisode.addLongProperty("fk_episode_id").notNull().getProperty();
		recommandedEpisode.addToOne(episode, episodeIdProperty);
		
		// episode to one newest episode
		episodeIdProperty = newestEpisode.addLongProperty("fk_episode_id").notNull().getProperty();
		newestEpisode.addToOne(episode, episodeIdProperty);
		
		// newest episode belongs to television
		televisionIdProperty = newestEpisode.addLongProperty("fk_television_id").notNull().getProperty();
		newestEpisode.addToOne(television, televisionIdProperty);
		
		///recommended to one episode
		Property recommandedIdProperty = episode.addLongProperty("fk_recommandedEpisode_id").notNull().getProperty();
		episode.addToOne(recommandedEpisode, recommandedIdProperty); */

	}
}
