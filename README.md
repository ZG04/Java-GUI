# Dietary Survey App

A Java Swing desktop application that collects dietary survey responses through a GUI and appends each submission to a CSV file.

## Overview

The survey collects: first name, last name, phone number, email, sex, average daily water intake (cups), average meals per day, whether meals regularly contain wheat/sugar/dairy, average daily walking distance, and weight. Each submission is timestamped and appended as a new row to `survey_results.csv`, with a "Clear" button to reset the form and a "Submit" button to save a response.

- **`Project4.java`** — entry point; launches the GUI.
- **`CustomJFrame.java`** — builds the survey form (`GridBagLayout`) with text fields, radio buttons, a spinner, a slider, checkboxes, and a combo box, and wires up submit/clear behavior via an inner `ActionListener`.
- **`FileHandler.java`** — creates `survey_results.csv` with a header row on startup and appends each new submission as a comma-separated row.

## Project Structure

```
DietarySurveyApp/
├── src/
│   ├── Project4.java        # Entry point
│   ├── CustomJFrame.java    # Swing GUI
│   └── FileHandler.java     # CSV file output
└── README.md
```

## Running It

1. Compile: `javac src/*.java -d out`
2. Run: `java -cp out Project4`
3. Fill out the form and click **Submit** — a `survey_results.csv` file is created (or appended to) in the working directory.

## Author

Zach Gray
