package com.learnjava.xmltreeexpressionevaluator;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
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
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
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
    private static NaturalNumber evaluate(XMLTree exp) {
        // create variables for the two children nodes of initial xml tree exp
        XMLTree child0 = exp.child(0);
        XMLTree child1 = exp.child(1);
        // create variable zero to check for division by 0 later
        NaturalNumber zero = new NaturalNumber2(0);
        // variable names to store numbers to do arithmetic with
        NaturalNumber child0Value = new NaturalNumber2(0);
        NaturalNumber child1Value = new NaturalNumber2(0);
        // result of adding/subtracting/multiplying/dividing the child variables
        NaturalNumber result = new NaturalNumber2(0);

        // check which math operation is needed in the root node
        // ---------------------- ADDITION -------------------------------------
        if (exp.label().equals("plus")) {
            // check whether the first child is a number
            if (child0.label().equals("number")) {
                String stringNum = child0.attributeValue("value");
                // assign the node's attribute value to a variable if label is a number
                NaturalNumber naturalnumberNum = new NaturalNumber2(
                        Integer.parseInt(stringNum));
                child0Value.copyFrom(naturalnumberNum);
            } else {
                // make this child node the root and call evaluate again
                child0Value = evaluate(child0);
            }
            // check whether the second child is a number
            if (child1.label().equals("number")) {
                String stringNum = child1.attributeValue("value");
                NaturalNumber naturalnumberNum = new NaturalNumber2(
                        Integer.parseInt(stringNum));
                // assign the node's attribute value to a variable if label is a number
                child1Value.copyFrom(naturalnumberNum);
            } else {
                // make this child node the root and call evaluate again
                child1Value = evaluate(child1);
            }
            // assigns result to the sum of the two children
            result.add(child0Value);
            result.add(child1Value);

            // -------------------- SUBTRACTION --------------------------------
        } else if (exp.label().equals("minus")) {
            // check whether the first child is a number
            if (child0.label().equals("number")) {
                String stringNum = child0.attributeValue("value");
                // assign the node's attribute value to a variable if label is a number
                NaturalNumber naturalnumberNum = new NaturalNumber2(
                        Integer.parseInt(stringNum));
                child0Value.copyFrom(naturalnumberNum);
            } else {
                // make this child node the root and call evaluate again
                child0Value = evaluate(child0);
            }
            // check whether the second child is a number
            if (child1.label().equals("number")) {
                String stringNum = child1.attributeValue("value");
                NaturalNumber naturalnumberNum = new NaturalNumber2(
                        Integer.parseInt(stringNum));
                // assign the node's attribute value to a variable if label is a number
                child1Value.copyFrom(naturalnumberNum);
            } else {
                // make this child node the root and call evaluate again
                child1Value = evaluate(child1);
            }
            // check if subtracting child1 from child0 would result in a negative number
            if (child0Value.compareTo(child1Value) < 0) {
                Reporter.fatalErrorToConsole(
                        "fatal error: natural number cannot be negative sorry");
            }
            // assigns result to the difference of the two children
            result.add(child0Value);
            result.subtract(child1Value);

            // -------------------- MULTIPLICATION -----------------------------
        } else if (exp.label().equals("times")) {
            // check whether the first child is a number
            if (child0.label().equals("number")) {
                String stringNum = child0.attributeValue("value");
                // assign the node's attribute value to a variable if label is a number
                NaturalNumber naturalnumberNum = new NaturalNumber2(
                        Integer.parseInt(stringNum));
                child0Value.copyFrom(naturalnumberNum);
            } else {
                // make this child node the root and call evaluate again
                child0Value = evaluate(child0);
            }
            // check whether the second child is a number
            if (child1.label().equals("number")) {
                String stringNum = child1.attributeValue("value");
                NaturalNumber naturalnumberNum = new NaturalNumber2(
                        Integer.parseInt(stringNum));
                // assign the node's attribute value to a variable if label is a number
                child1Value.copyFrom(naturalnumberNum);
            } else {
                // make this child node the root and call evaluate again
                child1Value = evaluate(child1);
            }
            // assigns result to the product of the two children
            result.add(child0Value);
            result.multiply(child1Value);

            // ---------------------- DIVISION ---------------------------------
        } else {
            // check whether the first child is a number
            if (child0.label().equals("number")) {
                String stringNum = child0.attributeValue("value");
                // assign the node's attribute value to a variable if label is a number
                NaturalNumber naturalnumberNum = new NaturalNumber2(
                        Integer.parseInt(stringNum));
                child0Value.copyFrom(naturalnumberNum);
            } else {
                // make this child node the root and call evaluate again
                child0Value = evaluate(child0);
            }
            // check whether the second child is a number
            if (child1.label().equals("number")) {
                String stringNum = child1.attributeValue("value");
                NaturalNumber naturalnumberNum = new NaturalNumber2(
                        Integer.parseInt(stringNum));
                // assign the node's attribute value to a variable if label is a number
                child1Value.copyFrom(naturalnumberNum);
            } else {
                // make this child node the root and call evaluate again
                child1Value = evaluate(child1);
            }
            // check if division by zero is occurring
            if (child1Value.compareTo(zero) == 0) {
                Reporter.fatalErrorToConsole(
                        "fatal error: cannot divide by zero");
            }
            // assigns result to the quotient of the two children
            result.add(child0Value);
            result.divide(child1Value);
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
