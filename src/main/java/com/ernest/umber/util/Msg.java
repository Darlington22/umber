package com.ernest.umber.util;

import org.omnifaces.util.Messages;

public class Msg
{
  public static void successSave()
  {
    Messages.addGlobalInfo("Saved successfully", new Object[0]);
  }

  public static void failedSave() {
    Messages.addGlobalError("Saving failed", new Object[0]);
  }

  public static void successDelete() {
    Messages.addGlobalInfo("Deleted successfully", new Object[0]);
  }

  public static void failedDelete() {
    Messages.addGlobalError("Deleting failed", new Object[0]);
  }

  public static void reportInitiated() {
    Messages.addGlobalInfo("Report generation initiated", new Object[0]);
  }

  public static void genericInfo(String info) {
    Messages.addGlobalInfo(info, new Object[0]);
  }

  public static void genericError(String error) {
    Messages.addGlobalError(error, new Object[0]);
  }
}