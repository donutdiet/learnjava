package com.learnjava.xmltreeexpressionevaluator;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static int evaluate(XMLTree exp) {
        // create variables for the two children nodes of initial xml tree exp
        XMLTree child0 = exp.child(0);
        XMLTree child1 = exp.child(1);
        // variables to store numbers to do arithmetic with
        int child0Value = 0;
        int child1Value = 0;
        // result of adding/subtracting/multiplying/dividing the child variables
        int result = 0;

        // check which math operation is needed in the root node
        // ---------------------- ADDITION -------------------------------------
        if (exp.label().equals("plus")) {
            // check whether the first child is a number
            if (child0.label().equals("number")) {
                String number = child0.attributeValue("value");
                // assign the node's attribute value to a variable if label is number
                child0Value = Integer.parseInt(number);
            } else {
                // make this child node the root and call evaluate again
                child0Value = evaluate(child0);
            }
            // check whether the second child is a number
            if (child1.label().equals("number")) {
                String number = child1.attributeValue("value");
                // assign the node's attribute value to a variable if label is number
                child1Value = Integer.parseInt(number);
            } else {
                // make this child node the root and call evaluate again
                child1Value = evaluate(child1);
            }
            // assigns result to the sum of the two children
            result = child0Value + child1Value;

            // --------------------- SUBTRACTION -------------------------------
        } else if (exp.label().equals("minus")) {
            // check whether the first child is a number
            if (child0.label().equals("number")) {
                String number = child0.attributeValue("value");
                // assign the node's attribute value to a variable if label is number
                child0Value = Integer.parseInt(number);
            } else {
                // make this child node the root and call evaluate again
                child0Value = evaluate(child0);
            }
            // check whether the second child is a number
            if (child1.label().equals("number")) {
                String number = child1.attributeValue("value");
                // assign the node's attribute value to a variable if label is number
                child1Value = Integer.parseInt(number);
            } else {
                // make this child node the root and call evaluate again
                child1Value = evaluate(child1);
            }
            // assigns result to the difference of the two children
            result = child0Value - child1Value;

            // ---------------------- MULTIPLICATION ---------------------------
        } else if (exp.label().equals("times")) {
            // check whether the first child is a number
            if (child0.label().equals("number")) {
                String number = child0.attributeValue("value");
                // assign the node's attribute value to a variable if label is number
                child0Value = Integer.parseInt(number);
            } else {
                // make this child node the root and call evaluate again
                child0Value = evaluate(child0);
            }
            // check whether the second child is a number
            if (child1.label().equals("number")) {
                String number = child1.attributeValue("value");
                // assign the node's attribute value to a variable if label is number
                child1Value = Integer.parseInt(number);
            } else {
                // make this child node the root and call evaluate again
                child1Value = evaluate(child1);
            }
            // assigns result to the product of the two children
            result = child0Value * child1Value;

            // ------------------------ DIVISION -------------------------------
        } else {
            // check whether the first child is a number
            if (child0.label().equals("number")) {
                String number = child0.attributeValue("value");
                // assign the node's attribute value to a variable if label is number
                child0Value = Integer.parseInt(number);
            } else {
                // make this child node the root and call evaluate again
                child0Value = evaluate(child0);
            }
            // check whether the second child is a number
            if (child1.label().equals("number")) {
                String number = child1.attributeValue("value");
                // assign the node's attribute value to a variable if label is number
                child1Value = Integer.parseInt(number);
            } else {
                // make this child node the root and call evaluate again
                child1Value = evaluate(child1);
            }
            // check if division by zero is occurring
            if (child1Value == 0) {
                Reporter.fatalErrorToConsole(
                        "fatal error: cannot divide by zero");
            }
            // assigns result to the quotient of the two children
            result = child0Value / child1Value;
        }
        return result;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // prompt and user for an xml file and store in variable
        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        // loop until user does not enter anything
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
