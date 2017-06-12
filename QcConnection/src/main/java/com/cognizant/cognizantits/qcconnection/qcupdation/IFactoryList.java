package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{68FE31A3-6242-4AA4-9BBE-D0715F810DB3}")
public abstract interface IFactoryList
  extends IList
{
  @DISPID(7)
  @VTID(14)
  public abstract IList fields();
  
  @VTID(14)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object fields(int paramInt);
  
  @DISPID(8)
  @VTID(15)
  public abstract void refresh();
  
  @DISPID(9)
  @VTID(16)
  public abstract void post();
  
  @DISPID(10)
  @VTID(17)
  public abstract int ratio(int paramInt);
  
  @DISPID(11)
  @VTID(18)
  public abstract int indexOfItem(@MarshalAs(NativeType.VARIANT) Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IFactoryList
 * JD-Core Version:    0.7.0.1
 */