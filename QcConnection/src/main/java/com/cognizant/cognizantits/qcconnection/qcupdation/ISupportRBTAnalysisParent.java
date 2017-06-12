package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;
import java.util.Date;

@IID("{C4BFEF87-D2BB-487F-B149-65B892644DFB}")
public abstract interface ISupportRBTAnalysisParent
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void analyzeButDontSave();
  
  @DISPID(2)
  @VTID(8)
  public abstract void analyzeAndSave();
  
  @DISPID(3)
  @VTID(9)
  public abstract void applyPolicyOnResultMatix();
  
  @DISPID(20)
  @VTID(10)
  public abstract int testingPolicyMatrix(int paramInt1, int paramInt2);
  
  @DISPID(20)
  @VTID(11)
  public abstract void testingPolicyMatrix(int paramInt1, int paramInt2, int paramInt3);
  
  @DISPID(21)
  @VTID(12)
  public abstract int testingLevelPercentage(int paramInt);
  
  @DISPID(21)
  @VTID(13)
  public abstract void testingLevelPercentage(int paramInt1, int paramInt2);
  
  @DISPID(22)
  @VTID(14)
  public abstract int fpLevelTestingEffortInHours(int paramInt);
  
  @DISPID(22)
  @VTID(15)
  public abstract void fpLevelTestingEffortInHours(int paramInt1, int paramInt2);
  
  @DISPID(23)
  @VTID(16)
  public abstract int availableTimeInHours();
  
  @DISPID(23)
  @VTID(17)
  public abstract void availableTimeInHours(int paramInt);
  
  @DISPID(24)
  @VTID(18)
  public abstract String analysisFilter();
  
  @DISPID(24)
  @VTID(19)
  public abstract void analysisFilter(String paramString);
  
  @DISPID(25)
  @VTID(20)
  public abstract int testingEffortInHoursFromPolicyMatrix(int paramInt1, int paramInt2);
  
  @DISPID(33)
  @VTID(21)
  public abstract boolean isAnalyzed();
  
  @DISPID(34)
  @VTID(22)
  public abstract int analysisResultCustomizedDurationInHours();
  
  @DISPID(35)
  @VTID(23)
  public abstract int analysisResultAnalyzedDurationInHours();
  
  @DISPID(36)
  @VTID(24)
  public abstract Date analysisResultLastAnalysisDate();
  
  @DISPID(37)
  @VTID(25)
  public abstract int analysisResultAggregatedRNDEffortsInHours();
  
  @DISPID(38)
  @VTID(26)
  public abstract int analysisResultCountIgnoredRequirements();
  
  @DISPID(39)
  @VTID(27)
  public abstract int analysisResultCountCustomizedRequirements();
  
  @DISPID(40)
  @VTID(28)
  public abstract int analysisResultCountUnanalyzableRequirements();
  
  @DISPID(41)
  @VTID(29)
  public abstract int analysisResultCountNonCustomizedRequirements(int paramInt1, int paramInt2);
  
  @DISPID(50)
  @VTID(30)
  public abstract void resetPolicyToDefaults();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISupportRBTAnalysisParent
 * JD-Core Version:    0.7.0.1
 */