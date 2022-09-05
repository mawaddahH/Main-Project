/**
 * @author Mawaddah Hanbali
 */
package mainProject.MuviCinemas;

import org.testng.annotations.DataProvider;

public class DataProviderData {
	
    @DataProvider (name = "Authentication")
    public Object[][] dpMethod(){
		// The number of times data is repeated, test will be executed the same no. of
		// times
		// Here it will execute two times
		return new Object[][] { { "ultrapower.team55@gmail.com", "##UltraPOWER5" },
				{ "ultrapower.team5@gmail.com", "##UltraPOWER55" } };
    } 

}
