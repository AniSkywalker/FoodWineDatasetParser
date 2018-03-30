package foodwinepairdatasetparser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FoodWineDatasetParser {

    ArrayList<ArrayList<Object>> pizzaIngredients;
    ArrayList<ArrayList<Object>> beverages;
    ArrayList<ArrayList<Object>> ListOfDesserts;

    public FoodWineDatasetParser() {
        this.pizzaIngredients = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.ListOfDesserts = new ArrayList<>();

    }

    public void loadPizzaIngredients(String filename) {

        try {
            // reading a file
            FileInputStream fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            String line;

            //reading a line
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\t");

                //getting the name
                String name = tokens[0];

                // getting the category
                String category = tokens[1];

                // getting the list of ingredients
                String[] ingredients = tokens[2].split(",");

                // getting the list of location where it can be bought
                // placeholder for location
                String[] locations = "NA".split(",");
                if (tokens.length > 3) {
                    locations = tokens[3].split(",");
                }

                ArrayList<Object> entry = new ArrayList<Object>();
                entry.add(name);
                entry.add(category);
                entry.add(ingredients);
                entry.add(locations);

                this.pizzaIngredients.add(entry);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadBeverages(String filename) {

        try {
            // reading a file
            FileInputStream fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            String line;

            //reading a line
            while ((line = br.readLine()) != null) {
                String[] tokens = line.trim().split("\t");

                // getting the name
                String name = tokens[0];

                // getting the nationality
                String nationality = tokens[1];

                // geeting the list of pairings
                String[] pairings = tokens[2].split(",");

                ArrayList<Object> entry = new ArrayList<Object>();
                entry.add(name);
                entry.add(nationality);
                entry.add(pairings);

                this.beverages.add(entry);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadListOfDesserts(String filename) {

        try {
            // reading a file
            FileInputStream fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            String line;

            //reading a line
            while ((line = br.readLine()) != null) {
                String[] tokens = line.trim().split("\t");

                // getting the name
                String name = tokens[0];

                // getting the list of ingredients
                String[] ingredients = tokens[1].split(",");

                ArrayList<Object> entry = new ArrayList<Object>();
                entry.add(name);
                entry.add(ingredients);

                this.ListOfDesserts.add(entry);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPizzaIngredients() {
        for (int i = 0; i < this.pizzaIngredients.size(); i++) {
            ArrayList<Object> row = this.pizzaIngredients.get(i);
            // printing the name
            System.out.println(row.get(0));
            // printing the category
            System.out.println(row.get(1));
            
            String[] ingredients = (String[])row.get(2);
            // printing the ingredients
            for (int j = 0; j < ingredients.length ; j++) {
                System.out.println(ingredients[j].trim());
            }
            
            String[] locations = (String[])row.get(3);
            // printing the locations
            for (int j = 0; j < locations.length ; j++) {
                System.out.println(locations[j]);
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        FoodWineDatasetParser fwdp = new FoodWineDatasetParser();

        fwdp.loadPizzaIngredients("resource/pizza_ingredients.tsv");
        fwdp.getPizzaIngredients();

    }

}
