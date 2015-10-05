package bonusAssignmentApplciation;

import java.util.ArrayList;
import java.util.Scanner;

public class BonusAssignmentProg {

	public static void main(String[] args) {

		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> majorList = new ArrayList<String>();
		ArrayList<String> stateList = new ArrayList<String>();
		ArrayList<String> GPAList = new ArrayList<String>();
		ArrayList<String> genderList = new ArrayList<String>();
		ArrayList<Double> numeGPA = new ArrayList<Double>();

		String tempGPA, tempGender, tempMajor, tempState;

		double totalGrades, totalFemale, totalMale, gradeNum;

		int femaleCount, maleCount;

		femaleCount = maleCount = 0;
		totalGrades = totalFemale = totalMale = 0;

		String keyword = "no";

		Scanner keyboard = new Scanner(System.in);

		System.out
				.println("Enter student details. Enter yes for quit and no to continue.");

		do {
			// NAME
			System.out.print("name: ");
			nameList.add(keyboard.next());

			// GPA
			System.out.print("grade: ");
			tempGPA = keyboard.next();
			tempGPA = tempGPA.toUpperCase();

			// check the equivalent numeric grade
			if (tempGPA.equals("A"))
				gradeNum = 4;
			else if (tempGPA.equals("B"))
				gradeNum = 3;
			else if (tempGPA.equals("C"))
				gradeNum = 2;
			else if (tempGPA.equals("D"))
				gradeNum = 1;
			else
				gradeNum = 0;

			// add the current grade to the total grades for all other students
			totalGrades = totalGrades + gradeNum;

			GPAList.add(tempGPA);
			numeGPA.add(gradeNum);

			// GENDER
			System.out.print("gender: ");
			tempGender = keyboard.next();
			tempGender = tempGender.toUpperCase();

			if (tempGender.equals("M")) {
				maleCount++;
				totalMale = totalMale + gradeNum;
			} else if (tempGender.equals("F")) {
				femaleCount++;
				totalFemale = totalFemale + gradeNum;
			}

			genderList.add(tempGender);

			// MAJOR
			System.out.print("major: ");
			tempMajor = keyboard.next();

			majorList.add(tempMajor);

			// STATE
			System.out.print("state: ");
			tempState = keyboard.next();
			tempState = tempState.toUpperCase();

			stateList.add(tempState);

			System.out.print("quit? ");
			keyword = keyboard.next();
		} while (keyword.equals("no"));

		keyboard.close();

		System.out.println("\n\n\n");
		// Print all entries
		for (int i = 0; i < GPAList.size(); i++) {
			System.out.println("\n\nStudent Name: " + nameList.get(i));
			System.out.println("GPA: " + GPAList.get(i));
			System.out.println("Gender: " + genderList.get(i));
			System.out.println("Major: " + majorList.get(i));
			System.out.println("State: " + stateList.get(i));
		}

		System.out.println("\n\n\n-------------------------");
		// print averages
		System.out.println("Total Average: " + (totalGrades / GPAList.size()));
		System.out.println("Average by Gender:");
		System.out.println("Females: " + totalFemale / femaleCount);
		System.out.println("Males: " + totalMale / maleCount);

		System.out.println("Average by Major: ");
		avgBy(majorList, numeGPA);

		System.out.println("Average by State: ");
		avgBy(stateList, numeGPA);

	}

	static void avgBy(ArrayList<String> avgBy, ArrayList<Double> gpa) {
		String temp = "";

		for (int i = 0; i < avgBy.size(); i++) {
			if (avgBy.get(i).equals("-"))
				continue;

			int div = 0;
			double totalGrade = 0;
			temp = avgBy.get(i).toString();
			avgBy.set(i, "-");

			totalGrade = totalGrade + gpa.get(i);
			div++;

			for (int j = i + 1; j < avgBy.size(); j++) {
				if (!avgBy.get(j).equals("-") && avgBy.get(j).equals(temp)) {
					avgBy.set(j, "-");
					totalGrade = totalGrade + gpa.get(j);
					div++;

				}

			}
			System.out.println(" " + temp + ": " + totalGrade / div);
		}

	}
}
