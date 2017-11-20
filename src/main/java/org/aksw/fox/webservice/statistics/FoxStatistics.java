package org.aksw.fox.webservice.statistics;

import java.util.HashMap;
import java.util.Map;

import org.aksw.fox.FoxParameter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FoxStatistics {
  public static Logger LOG = LogManager.getLogger(FoxStatistics.class);

  /**
   * Stores client informations in the log file.
   *
   * @param ip
   * @param parameterMap
   */
  public void client(final String ip, final Map<String, String> parameterMap) {

    // remove data we do not want in the log
    final Map<String, String> copy = new HashMap<String, String>(parameterMap);
    copy.remove(FoxParameter.Parameter.INPUT.toString().toLowerCase());
    copy.remove("docuri");
    copy.remove("defaults");
    copy.remove(FoxParameter.Parameter.NIF.toString().toLowerCase());
    copy.remove("state");

    // add data to the log file
    LOG.info("Client IP: ".concat(ip).concat("; parameter: ").concat(copy.toString()));
  }
}
