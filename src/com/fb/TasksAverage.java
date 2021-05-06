package com.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * t = ['task1', 'task2a', 'task2b', 'task3'] r = ['OK', 'Wrong Answer', 'OK', 'OK']
 *
 * <p>Each task is labeled with a task name, followed by the number of that task, and optionally a
 * letter to designate subtasks within that numbered task. Each element in t has a corresponding
 * element in r. A task is considered complete as long as its results all yield 'OK'. So for the
 * above example, task1 would be complete, task2 would not because 2a failed and task3 passed.
 * Therefore there were 2 tasks that completed successfully. In order to compute the final result,
 * take the passing tasks, times by 100 and then divide by the total number of tasks (3) to get the
 * result, and then take the whole number of that result.
 *
 * @author swamy on 2/17/21
 */
public class TasksAverage {
  public static void main(String[] args) {
      String[] test0 = {"task1", "task2a", "task2b", "task3"};
      String[] results0 = {"OK", "Wrong Answer", "OK", "OK"};
    /*  String[] test1 = {"test1", "test2a", "test2b", "merry1a", "test2c", "test3", "test5",
              "test6", "merry1b"};
      String[] results1 = {"OK", "OK", "Wrong answer", "OK", "Wrong answer", "Wrong answer",
              "OK", "TimeOut", "Runtime error"};
      int average1 = solution(test1, results1);

      String[] test2 = {"test1", "test2a", "test2b", "test4", "test2c", "test3", "test5",
              "test6", "test7"};
      String[] results2 = {"Runtime error", "OK", "Wrong answer", "OK", "TimeOut", "Wrong " +
              "answer", "OK", "Timeout", "TimeOut"};

      int average2 = solution(test2, results2);

      String[] test3 = {"test1", "test2a", "test2b", "test4", "test2c", "test3", "test5",
              "test6", "test7"};
      String[] results3 = {"OK", "OK", "TimeOut", "OK", "TimeOut", "OK", "TimeOut", "Runtime " +
              "error", "OK"};
      int average3 = solution(test3, results3);

      System.out.println("Avg1 = " + average1);
      System.out.println("Avg2 = " + average2);
      System.out.println("Avg3 = " + average3);*/
      int average = solution(test0, results0);
      System.out.println("Avg = " + average);


  }

    public static int solution(String[] tests, String[] results) {

        String regex = "(\\w*?)(\\d*)([a-z])?";
        Pattern pattern = Pattern.compile(regex);

        Map<String, TestResult> testResults = new HashMap<>();
        Map<String, TestSuiteResult> testSuiteResults = new HashMap<>();

        for (int i = 0; i < tests.length; i++) {

            String test = tests[i];
            Matcher matcher = pattern.matcher(test);

            // check for illegal test name
            if (!matcher.matches()) {
                continue;
            }

            String name = matcher.group(1);
            String digitPart = matcher.group(2);
            String character = matcher.group(3);

            if (character != null) {
                // multi test
                String suiteName = name + digitPart;
                TestSuiteResult suite = testSuiteResults.get(suiteName);
                if (suite == null) {
                    suite = new TestSuiteResult(suiteName);
                    testSuiteResults.put(suite.getName(), suite);
                }
                String result = results[i];
                TestResult multi = new TestResult(character, result);
                suite.getResults().add(multi);
            } else {
                // single test
                String result = results[i];
                TestResult single = new TestResult(test, result);
                testResults.put(single.getName(), single);
            }
        }

        int totalAmountOfTests = testResults.size() + testSuiteResults.size();

        int validTests = 0;
        for (Map.Entry<String, TestResult> entry : testResults.entrySet()) {
            if (entry.getValue().getResult().equals("OK")) {
                validTests++;
            }
        }
        for (Map.Entry<String, TestSuiteResult> entry : testSuiteResults.entrySet()) {
            List<TestResult> suiteResults = entry.getValue().getResults();
            boolean valid = true;
            for (TestResult suiteResult : suiteResults) {
                if (!suiteResult.getResult().equals("OK")) {
                    valid = false;
                }
            }
            if (valid) {
                validTests++;
            }
        }

        double average = (double) totalAmountOfTests / validTests;
        return (int) average;
    }

    private static class TestSuiteResult {
        private String name;
        private List<TestResult> results = new ArrayList<>();

        public TestSuiteResult(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<TestResult> getResults() {
            return results;
        }
    }

    private static class TestResult {
        private String name;
        private String result;

        public TestResult(String name, String result) {
            this.name = name;
            this.result = result;
        }

        public String getName() {
            return name;
        }

        public String getResult() {
            return result;
        }
    }
}
