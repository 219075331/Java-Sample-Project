package edu.sample;

import java.awt.EventQueue;

/**
 * Swingアプリ「足し算電卓」クラス実行クラス
 */
public class AdditionCalculatorRunner {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AdditionCalculator frame = new AdditionCalculator();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
