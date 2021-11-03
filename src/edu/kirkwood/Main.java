package edu.kirkwood;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Widget[] widgets = new Widget[20];

        // STEP 3: Create a Predicate called "zeroOrGreater" to test if a Widget's value is greater than or equal to 0.
        // This will take a single Widget as input, use the .getValue() method, and return a boolean.
        // This code should be written on a single line.
        Predicate<Widget> zeroOrGreater = w -> w.getValue() >= 0;

        // STEP 5: Create a UnaryOperator called "nameToLower" to convert the Widget name to all lowercase letters.
        // This will take a single Widget as input, use both the .getName() and .setName() methods, and return the updated Widget.
        UnaryOperator<Widget> nameToLower = (w) ->
        {
            w.setName(w.getName().toLowerCase());
            //ERROR: java: incompatible types: void cannot be converted to java.lang.String
            return w;
        };

        // STEP 8: Create a Consumer called "print" to print each Widget as a string on a new line using the .toString() method.
        // This code should be written on a single line.
        Consumer<Widget> print = w -> System.out.println(w);



        for(int i = 0; i < 20; i++) {
            // STEP 1: Create a Supplier object called "widgetCreator" using a method reference.
            Supplier<Widget> widgetCreator = Widget::new;

            // STEP 2: Using the "widgetCreator", instantiate a new Widget object called "widget".
            Widget w = widgetCreator.get();

            // STEP 4: Write an if statement that uses the Predicate's abstract method as the condition.
            if(zeroOrGreater.test(w)){
                // STEP 6: If true, use the UnaryOperator's abstract method to change the widget's name to lowercase.
               w = nameToLower.apply(w);
                // STEP 7: add the widget to the array
                widgets[i] = w;
                /*
                    ERROR:
                    java: cannot find symbol
                    symbol:   method add(edu.kirkwood.Widget)
                    location: variable widgets of type edu.kirkwood.Widget[]
                */
            }

        } // End the loop here

        for(Widget widget: widgets) {
            // STEP 9: Use the Consumer's abstract method to print each widget.
            print.accept(widget);
        }
    }
}
