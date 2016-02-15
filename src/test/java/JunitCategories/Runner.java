package JunitCategories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Alexander on 15.02.2016.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(CategoryClass01.class)
@Categories.ExcludeCategory(CategoryClass02.class)
@Suite.SuiteClasses({TestClass01.class, TestClass02.class})
public class Runner {
}
