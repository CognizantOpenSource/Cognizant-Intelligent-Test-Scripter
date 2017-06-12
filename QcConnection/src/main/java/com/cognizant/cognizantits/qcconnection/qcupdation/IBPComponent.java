package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{42AD6542-9DBC-4A66-BC3F-7692832D33CB}")
public abstract interface IBPComponent
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject component();
  
  @DISPID(15)
  @VTID(24)
  public abstract int order();
  
  @DISPID(15)
  @VTID(25)
  public abstract void order(int paramInt);
  
  @DISPID(16)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject test();
  
  @DISPID(17)
  @VTID(27)
  public abstract String failureCondition();
  
  @DISPID(17)
  @VTID(28)
  public abstract void failureCondition(String paramString);
  
  @DISPID(18)
  @VTID(29)
  public abstract String name();
  
  @DISPID(19)
  @VTID(30)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject group();
  
  @DISPID(20)
  @VTID(31)
  public abstract void groupId(int paramInt);
  
  @DISPID(21)
  @VTID(32)
  public abstract IList bpParams();
  
  @VTID(32)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object bpParams(int paramInt);
  
  @DISPID(22)
  @VTID(33)
  public abstract IList iterations();
  
  @VTID(33)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object iterations(int paramInt);
  
  @DISPID(23)
  @VTID(34)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addIteration();
  
  @DISPID(24)
  @VTID(35)
  public abstract void deleteIteration(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(25)
  @VTID(36)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject _AddBPParameter(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBPComponent
 * JD-Core Version:    0.7.0.1
 */