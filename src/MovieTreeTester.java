import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 */

public class MovieTreeTester {

  public static boolean testAddMovieToStringSize() {
    MovieTree addMovieTest = new MovieTree();

    // Test One: checking values of an empty tree

    if (addMovieTest.size() != 0) {
      System.out.println("Expected size: 0; Actual size: " + addMovieTest.size());
      return false;
    }
    if (!addMovieTest.isEmpty()) {
      System.out.println("Movie tree wasn't empty when it shouldn't have been.");
      return false;
    }
    if (!addMovieTest.toString().equals("")) {
      System.out.println("String expected: \"\"; String actual: " + addMovieTest.toString());
      return false;
    }

    // Test Two: adding movie to an empty tree
    Movie testOne = new Movie(2019, 3.7, "Chicken Little");

    if (!addMovieTest.addMovie(testOne)) {
      System.out.println("addMovie returned false when it should have returned true.");
      return false;
    }

    if (addMovieTest.size() != 1) {
      System.out.println("Expected size: 1; Actual size: " + addMovieTest.size());
      return false;
    }
    if (addMovieTest.isEmpty()) {
      System.out.println("Movie tree was empty when it shouldn't have been.");
      return false;
    }
    if (!addMovieTest.toString().equals("[(Year: 2019) (Rate: 3.7) (Name: Chicken Little)]\n")) {
      System.out.println(
          "String expected:\n[(Year: 2019) (Rate: 3.7) (Name: Chicken Little)]\nString actual:\n"
              + addMovieTest.toString());
      return false;
    }

    // Test Three: adding movie to a tree with root that is bigger than the one being added
    Movie testTwo = new Movie(2014, 1.2, "The Bee Movie");

    if (!addMovieTest.addMovie(testTwo)) {
      System.out.println("addMovie returned false when it should have returned true.");
      return false;
    }

    if (addMovieTest.size() != 2) {
      System.out.println("Expected size: 2; Actual size: " + addMovieTest.size());
      return false;
    }
    if (addMovieTest.isEmpty()) {
      System.out.println("Movie tree was empty when it shouldn't have been.");
      return false;
    }
    if (!addMovieTest.toString().equals("[(Year: 2014) (Rate: 1.2) (Name: The Bee Movie)]\n"
        + "[(Year: 2019) (Rate: 3.7) (Name: Chicken Little)]\n")) {
      System.out.println("String expected:\n" + "[(Year: 2014) (Rate: 1.2) (Name: The Bee Movie)]\n"
          + "[(Year: 2019) (Rate: 3.7) (Name: Chicken Little)]\n" + "String actual:\n"
          + addMovieTest.toString());
      return false;
    }

    // Test Four: adding movie to a tree with root that is smaller than the one being added
    Movie testThree = new Movie(2021, 5.3, "Shrek 5");

    if (!addMovieTest.addMovie(testThree)) {
      System.out.println("addMovie returned false when it should have returned true.");
      return false;
    }

    if (addMovieTest.size() != 3) {
      System.out.println("Expected size: 3; Actual size: " + addMovieTest.size());
      return false;
    }
    if (addMovieTest.isEmpty()) {
      System.out.println("Movie tree was empty when it shouldn't have been.");
      return false;
    }
    if (!addMovieTest.toString()
        .equals("[(Year: 2014) (Rate: 1.2) (Name: The Bee Movie)]\n"
            + "[(Year: 2019) (Rate: 3.7) (Name: Chicken Little)]\n"
            + "[(Year: 2021) (Rate: 5.3) (Name: Shrek 5)]\n")) {
      System.out.println("String expected:\n" + "[(Year: 2014) (Rate: 1.2) (Name: The Bee Movie)]\n"
          + "[(Year: 2019) (Rate: 3.7) (Name: Chicken Little)]\n"
          + "[(Year: 2021) (Rate: 5.3) (Name: Shrek 5)]\n" + "String actual:\n"
          + addMovieTest.toString());
      return false;
    }

    // Test Five: adding additional movies to the tree
    Movie testFour = new Movie(2023, 6.1, "The Room by Tommy Wiseau");
    Movie testFive = new Movie(2021, 4.9, "Stuart Little");

    if (!addMovieTest.addMovie(testFour)) {
      System.out.println("addMovie returned false when it should have returned true.");
      return false;
    }

    if (!addMovieTest.addMovie(testFive)) {
      System.out.println("addMovie returned false when it should have returned true.");
      return false;
    }

    if (addMovieTest.size() != 5) {
      System.out.println("Expected size: 5; Actual size: " + addMovieTest.size());
      return false;
    }

    if (addMovieTest.isEmpty()) {
      System.out.println("Movie tree was empty when it shouldn't have been.");
      return false;
    }
    if (!addMovieTest.toString()
        .equals("[(Year: 2014) (Rate: 1.2) (Name: The Bee Movie)]\n"
            + "[(Year: 2019) (Rate: 3.7) (Name: Chicken Little)]\n"
            + "[(Year: 2021) (Rate: 4.9) (Name: Stuart Little)]\n"
            + "[(Year: 2021) (Rate: 5.3) (Name: Shrek 5)]\n"
            + "[(Year: 2023) (Rate: 6.1) (Name: The Room by Tommy Wiseau)]\n")) {
      System.out.println("Unexpected String.");
      return false;
    }

    // Test Six: adding existing movie to the tree
    Movie testSix = new Movie(2023, 6.1, "The Room by Tommy Wiseau");

    if (addMovieTest.addMovie(testSix)) {
      System.out.println("test 6 addMovie returned true when it should have returned false.");
      return false;
    }

    if (addMovieTest.size() != 5) {
      System.out.println("Expected size: 5; Actual size: " + addMovieTest.size());
      return false;
    }

    if (addMovieTest.isEmpty()) {
      System.out.println("Movie tree was empty when it shouldn't have been.");
      return false;
    }

    if (!addMovieTest.toString()
        .equals("[(Year: 2014) (Rate: 1.2) (Name: The Bee Movie)]\n"
            + "[(Year: 2019) (Rate: 3.7) (Name: Chicken Little)]\n"
            + "[(Year: 2021) (Rate: 4.9) (Name: Stuart Little)]\n"
            + "[(Year: 2021) (Rate: 5.3) (Name: Shrek 5)]\n"
            + "[(Year: 2023) (Rate: 6.1) (Name: The Room by Tommy Wiseau)]\n")) {
      System.out.println("Unexpected String.");
      return false;
    }

    return true;
  }

  /**
   * This method checks mainly for the correctness of the MovieTree.contains() method. It must
   * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
   * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
   * height 3 which contains at least 5 movies. Then, try to call contains() method to search for
   * the movie having a match at the root of the tree. (3) Then, search for a movie at the right and
   * left subtrees at different levels considering successful and unsuccessful search operations.
   * Make sure that the contains() method returns the expected output for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {

    MovieTree testContains = new MovieTree();

    // Test One: checking values of an empty tree
    if (testContains.contains(2012, 3.4, "Rango")) {
      System.out.println("Movie tree returned true when it should have returned false");
      return false;
    }

    // Test Two/Three: checking for real and fake movies in a tree that contains matches
    testContains.addMovie(new Movie(2012, 3.4, "Rango"));
    testContains.addMovie(new Movie(2004, 2.4, "Cars 7"));
    testContains.addMovie(new Movie(2019, 4.6, "Steak"));
    testContains.addMovie(new Movie(2014, 3.2, "Wallace and Grommit"));
    testContains.addMovie(new Movie(2021, 5.6, "Chicken Sandwich"));

    // real on right at height 2
    if (!testContains.contains(2021, 5.6, "Chicken Sandwich")) {
      System.out.println("Movie tree returned false when it should have returned true");
      return false;
    }

    // real on right at height 1
    if (!testContains.contains(2019, 4.6, "Steak")) {
      System.out.println("Movie tree returned false when it should have returned true");
      return false;
    }

    // real on left at height 1
    if (!testContains.contains(2004, 2.4, "Cars 7")) {
      System.out.println("Movie tree returned false when it should have returned true");
      return false;
    }

    // fake movie not in tree
    if (testContains.contains(2016, 10.0, "Bee Movie 2")) {
      System.out.println("Movie tree returned false when it should have returned true");
      return false;
    }

    return true;
  }

  /**
   * Checks for the correctness of MovieTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
   * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
   * MovieTree with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*) (*) /
   * (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {

    MovieTree testHeight = new MovieTree();

    // Test One: checking values of an empty tree
    if (testHeight.height() != 0) {
      System.out.println("Expected height: 0; Actual height: " + testHeight.height());
      return false;
    }

    // Test Two: checking values in tree with one value
    testHeight.addMovie(new Movie(2012, 3.4, "Rango"));
    if (testHeight.height() != 1) {
      System.out.println("Expected height: 1; Actual height: " + testHeight.height());
      return false;
    }

    // Test Three: checking values in tree with many values
    testHeight.addMovie(new Movie(2004, 2.4, "Cars 7"));
    testHeight.addMovie(new Movie(2019, 4.6, "Steak"));
    testHeight.addMovie(new Movie(2014, 3.2, "Wallace and Grommit"));
    testHeight.addMovie(new Movie(2021, 2.3, "Jumanji 7"));
    testHeight.addMovie(new Movie(2019, 4.8, "Over the Hedge 14"));
    if (testHeight.height() != 4) {
      System.out.println("Expected height: 4; Actual height: " + testHeight.height());
      return false;
    }


    return true;
  }

  /**
   * Checks for the correctness of MovieTree.getBestMovie() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestMovie() {
    try {

    MovieTree testGetBestMovie = new MovieTree();

    // Test One: checking values of an empty tree
    if (testGetBestMovie.getBestMovie() != null) {
      System.out.println(
          "Movie tree returned something other than null when it should have returned null");
      return false;
    }

    // Test Two: checking for best movie in populated tree
    testGetBestMovie.addMovie(new Movie(2012, 3.4, "Rango"));
    testGetBestMovie.addMovie(new Movie(2004, 2.4, "Cars 7"));
    testGetBestMovie.addMovie(new Movie(2019, 4.6, "Steak"));
    testGetBestMovie.addMovie(new Movie(2014, 3.2, "Wallace and Grommit"));
    Movie bestMovie = new Movie(2021, 5.6, "Chicken Sandwich");
    testGetBestMovie.addMovie(bestMovie);

    if (!testGetBestMovie.getBestMovie().equals(bestMovie)) {
      System.out.println("Best movie wasn't returned. Expected: Chicken Sandwich; Actual: "
          + testGetBestMovie.getBestMovie().getName());
      return false;
    }
    return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
   * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
   * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
   * list which contains all the movies satisfying the search criteria of year and rating, when
   * called on a non empty movie tree with one match, and two matches and more. Vary your search
   * criteria such that the lookup() method must check in left and right subtrees. (3) Ensures that
   * the MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie
   * tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    
    MovieTree testLookup = new MovieTree();

    // Test One: looking for values in an empty tree
    try {
      testLookup.lookup(2012, 5.4);
    } catch (NoSuchElementException e) {


      // Test Two: looking for movies in populated tree
      Movie lookupOne = new Movie(2014, 5.4, "Cars 7");
      Movie lookupTwo = new Movie(2014, 5.6, "Popeye");
      Movie lookupThree = new Movie(2014, 8.4, "Pacific Rim");

      testLookup.addMovie(lookupOne);
      testLookup.addMovie(lookupTwo);
      testLookup.addMovie(lookupThree);
      testLookup.addMovie(new Movie(2012, 7.4, "Rango"));
      testLookup.addMovie(new Movie(2019, 4.6, "Steak"));
      testLookup.addMovie(new Movie(2014, 3.2, "Wallace and Grommit"));
      testLookup.addMovie(new Movie(2012, 4.4, "Cheese"));
      testLookup.addMovie(new Movie(2013, 4.6, "Eggs"));
      testLookup.addMovie(new Movie(2021, 2.3, "Jumanji 7"));
      testLookup.addMovie(new Movie(2022, 4.8, "Over the Hedge 14"));

      ArrayList<Movie> expected = new ArrayList<Movie>();
      expected.add(lookupOne);
      expected.add(lookupTwo);
      expected.add(lookupThree);

      if (!testLookup.lookup(2014, 5.0).equals(expected)) {
        System.out.println("Lookup failed to return the proper ArrayList.");
        return false;
      }

      // Test Three: looking for value that isn't in a tree
      try {
        testLookup.lookup(2021, 5.4);
      } catch (NoSuchElementException f) {
        return true;
      }

      System.out.println("An exception wasn't thrown for a value not in the tree");
      return false;
    }

    System.out.println("An exception wasn't thrown for an empty tree");
    return false;

  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    if (testAddMovieToStringSize()) {
      System.out.println("testAddMovieToString passed!");
    }

    if (testContains()) {
      System.out.println("testContains passed!");
    }

    if (testGetBestMovie()) {
      System.out.println("testGetBestMovie passed!");
    }

    if (testLookup()) {
      System.out.println("testLookup passed!");
    }

    if (testHeight()) {
      System.out.println("testHeight passed!");
    }

  }

}
