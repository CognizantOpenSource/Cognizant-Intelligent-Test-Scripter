package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{C3022DB1-251B-4F4F-A176-8A4A3811CF66}")
public abstract interface IComparisonResult
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String type();
  
  @DISPID(2)
  @VTID(8)
  public abstract String id1();
  
  @DISPID(3)
  @VTID(9)
  public abstract String id2();
  
  @DISPID(4)
  @VTID(10)
  public abstract IList fields();
  
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object fields(int paramInt);
  
  @DISPID(5)
  @VTID(11)
  public abstract String ownerType();
  
  @DISPID(6)
  @VTID(12)
  public abstract String ownerKey1();
  
  @DISPID(7)
  @VTID(13)
  public abstract String ownerKey2();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComparisonResult
 * JD-Core Version:    0.7.0.1
 */