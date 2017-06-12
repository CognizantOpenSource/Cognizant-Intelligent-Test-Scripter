package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{16E049C8-05E8-4D98-B9F4-CED6BCC763FD}")
public abstract interface ISupportRBTAnalysisChild
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String analyzedTestingLevel();
  
  @DISPID(2)
  @VTID(8)
  public abstract int analyzedTestingEffortInHours();
  
  @DISPID(10)
  @VTID(9)
  public abstract boolean useCustomTLAndTE();
  
  @DISPID(10)
  @VTID(10)
  public abstract void useCustomTLAndTE(boolean paramBoolean);
  
  @DISPID(11)
  @VTID(11)
  public abstract String customTestingLevel();
  
  @DISPID(11)
  @VTID(12)
  public abstract void customTestingLevel(String paramString);
  
  @DISPID(12)
  @VTID(13)
  public abstract int customTestingEffortInHours();
  
  @DISPID(12)
  @VTID(14)
  public abstract void customTestingEffortInHours(int paramInt);
  
  @DISPID(31)
  @VTID(15)
  public abstract int rnDEstimatedEffortInHours();
  
  @DISPID(31)
  @VTID(16)
  public abstract void rnDEstimatedEffortInHours(int paramInt);
  
  @DISPID(41)
  @VTID(17)
  public abstract boolean ignoreInAnalysis();
  
  @DISPID(41)
  @VTID(18)
  public abstract void ignoreInAnalysis(boolean paramBoolean);
  
  @DISPID(50)
  @VTID(19)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject parentRequirementForRBTAnalysis();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISupportRBTAnalysisChild
 * JD-Core Version:    0.7.0.1
 */