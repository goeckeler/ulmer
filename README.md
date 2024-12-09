# ulmer
Fingerfood coding. Students' project at Hochschule Neu-Ulm during summer term 2024.

## Task
Create a Java program that uses a graphical user interface based on Swing to create objects of a class defined by you, save them in a list and output them again according to defined criteria.
The attribute values of the objects are to be entered via the interface elements, the objects are to be created and saved in a list after the button is clicked (save), and only certain objects in the list are to be output or values calculated based on the saved objects after another button is clicked. A method that you define in the class that is used to model these objects should be used for this. 

You can check the correct functioning of this method with a corresponding JUnit test and it is up to you which objects you create. For example, you could create objects of the "Bag" class with the properties: Color, Weight, isVegan, Price and e.g. only output all redBags or calculate the average price of all bags. Remember to define at least one method in the "Bag" class that you use and test via JUnit so that some (at least 3) objects are already available at the start of the program, you should create them in a public void initObjekte() method and save them in the list. Please call this method at a suitable point in your program.

## Requirements
The following requirements must be implemented:

* The objects must have at least 3 attributes. The attributes must be able to be assigned to at least 3 different data types.
* The descriptive class of these objects has at least one method that you test using JUnit.
* You create and use the initObjects method, whose task is to create at least 3 objects of your class and save them to your list.
* Further objects should be created by entering the respective attribute values on the surface and using the Save button to create the individual objects and save them to the list. If entries are made incorrectly, e.g. letters are entered in the input field for entering a number, the program should display a corresponding error message.
* The objects saved in the list only remain available for the duration of the program, i.e. after each restart of the program, the list is recreated.
* In addition to the Save button, there must be at least one other button that initiates this selective selection or the calculation of values. You can decide for yourself which logic is the basis for this and which other input data you may need for this.
* In addition, there should be an area on the GUI in which all objects in the list are displayed and in which a filter can be set according to one of the attributes and sorting can be carried out in a column.
* Clean exception handling must be implemented.
