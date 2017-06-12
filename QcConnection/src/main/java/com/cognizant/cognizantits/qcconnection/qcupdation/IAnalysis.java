package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{557AF6E9-FB13-4934-9A8F-6620BA38C547}")
public abstract interface IAnalysis
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String filterText();
  
  @DISPID(1)
  @VTID(8)
  public abstract void filterText(String paramString);
  
  @DISPID(2)
  @VTID(9)
  public abstract String type();
  
  @DISPID(2)
  @VTID(10)
  public abstract void type(String paramString);
  
  @DISPID(3)
  @VTID(11)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object getDistinctValues(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(12)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object getSummaryData(@MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2);
  
  @DISPID(5)
  @VTID(13)
  public abstract String joinCondition();
  
  @DISPID(5)
  @VTID(14)
  public abstract void joinCondition(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAnalysis
 * JD-Core Version:    0.7.0.1
 */