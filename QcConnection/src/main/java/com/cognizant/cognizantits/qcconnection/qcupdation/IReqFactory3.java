package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{FDF842AD-361C-4F9A-82E6-6A2DB156FD27}")
public abstract interface IReqFactory3
  extends IReqFactory2
{
  @DISPID(20)
  @VTID(28)
  public abstract IList getTracedList(int paramInt1, int paramInt2);
  
  @DISPID(21)
  @VTID(29)
  public abstract IList getRequirementTypes();
  
  @VTID(29)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object getRequirementTypes(int paramInt);
  
  @DISPID(22)
  @VTID(30)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getRequirementType(String paramString);
  
  @DISPID(23)
  @VTID(31)
  public abstract String reqTypeIdToName(int paramInt);
  
  @DISPID(24)
  @VTID(32)
  public abstract IList getRequirementsSummaryStatus(String paramString1, String paramString2, IList paramIList);
  
  @DISPID(25)
  @VTID(33)
  public abstract IList getRequirementsByStatus(String paramString1, String paramString2, IList paramIList);
  
  @DISPID(26)
  @VTID(34)
  public abstract IList getCoverageTestsByReqFilter(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReqFactory3
 * JD-Core Version:    0.7.0.1
 */