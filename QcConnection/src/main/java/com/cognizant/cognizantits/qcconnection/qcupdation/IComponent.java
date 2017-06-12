package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E8BFF66F-A020-4909-B9E3-1591182D27D7}")
public abstract interface IComponent
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject componentParamFactory();
  
  @DISPID(18)
  @VTID(24)
  public abstract String name();
  
  @DISPID(18)
  @VTID(25)
  public abstract void name(String paramString);
  
  @DISPID(19)
  @VTID(26)
  public abstract IList businessProcesses();
  
  @VTID(26)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object businessProcesses(int paramInt);
  
  @DISPID(20)
  @VTID(27)
  public abstract boolean isIteratable();
  
  @DISPID(20)
  @VTID(28)
  public abstract void isIteratable(boolean paramBoolean);
  
  @DISPID(21)
  @VTID(29)
  public abstract boolean isObsolete();
  
  @DISPID(22)
  @VTID(30)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject folder();
  
  @DISPID(23)
  @VTID(31)
  public abstract boolean hasScript();
  
  @DISPID(24)
  @VTID(32)
  public abstract boolean hasPicture();
  
  @DISPID(24)
  @VTID(33)
  public abstract void hasPicture(boolean paramBoolean);
  
  @DISPID(25)
  @VTID(34)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject extendedStorage(int paramInt);
  
  @DISPID(26)
  @VTID(35)
  public abstract String scriptType();
  
  @DISPID(26)
  @VTID(36)
  public abstract void scriptType(String paramString);
  
  @DISPID(27)
  @VTID(37)
  public abstract void deletePicture(String paramString);
  
  @DISPID(28)
  @VTID(38)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject componentStepFactory();
  
  @DISPID(29)
  @VTID(39)
  public abstract void setStepsData();
  
  @DISPID(30)
  @VTID(40)
  public abstract int applicationAreaID();
  
  @DISPID(30)
  @VTID(41)
  public abstract void applicationAreaID(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComponent
 * JD-Core Version:    0.7.0.1
 */