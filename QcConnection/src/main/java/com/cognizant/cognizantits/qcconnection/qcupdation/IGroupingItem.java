package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{31FDA98D-C50C-416D-BB4F-9D5294896175}")
public abstract interface IGroupingItem
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String fieldName();
  
  @DISPID(2)
  @VTID(8)
  public abstract String fieldValue();
  
  @DISPID(3)
  @VTID(9)
  public abstract int itemCount();
  
  @DISPID(4)
  @VTID(10)
  public abstract IList itemList();
  
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object itemList(int paramInt);
  
  @DISPID(5)
  @VTID(11)
  public abstract IList groupList();
  
  @VTID(11)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object groupList(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IGroupingItem
 * JD-Core Version:    0.7.0.1
 */