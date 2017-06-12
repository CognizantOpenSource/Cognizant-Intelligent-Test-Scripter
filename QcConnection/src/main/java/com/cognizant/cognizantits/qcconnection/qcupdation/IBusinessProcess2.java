package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{CED907EB-C569-490F-84B1-C3E106C536AA}")
public abstract interface IBusinessProcess2
  extends IBusinessProcess
{
  @DISPID(117)
  @VTID(65)
  public abstract IList flowOutputParameters();
  
  @VTID(65)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object flowOutputParameters(int paramInt);
  
  @DISPID(118)
  @VTID(66)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addFlowOutputParam(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject, int paramInt, String paramString);
  
  @DISPID(119)
  @VTID(67)
  public abstract void deleteFlowOutputParam(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(120)
  @VTID(68)
  public abstract boolean isWithFlows();
  
  @DISPID(121)
  @VTID(69)
  public abstract boolean hasDynamicDateParameterValue();
  
  @DISPID(122)
  @VTID(70)
  public abstract boolean lockComponents();
  
  @DISPID(123)
  @VTID(71)
  public abstract void unlockALLComponents();
  
  @DISPID(124)
  @VTID(72)
  public abstract IList getParameterGroups(int paramInt);
  
  @DISPID(125)
  @VTID(73)
  public abstract IList getRTParamOccurrences(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBusinessProcess2
 * JD-Core Version:    0.7.0.1
 */