package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{F96FB8D9-0CD2-4B82-85FA-AB07C435F87F}")
public abstract interface IBPIteration
  extends IBaseField
{
  @DISPID(14)
  @VTID(20)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject bpComponent();
  
  @DISPID(15)
  @VTID(21)
  public abstract IList iterationParams();
  
  @VTID(21)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object iterationParams(int paramInt);
  
  @DISPID(16)
  @VTID(22)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addParam(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(17)
  @VTID(23)
  public abstract void deleteParam(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(18)
  @VTID(24)
  public abstract void deleteIterationParams();
  
  @DISPID(19)
  @VTID(25)
  public abstract int order();
  
  @DISPID(19)
  @VTID(26)
  public abstract void order(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBPIteration
 * JD-Core Version:    0.7.0.1
 */