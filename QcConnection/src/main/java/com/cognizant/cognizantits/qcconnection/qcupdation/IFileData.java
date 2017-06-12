package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{3A2C3A43-4D96-4682-91CC-9E091B64C1FE}")
public abstract interface IFileData
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  public abstract String name();
  
  @DISPID(1)
  @VTID(8)
  public abstract short type();
  
  @DISPID(2)
  @VTID(9)
  public abstract int size();
  
  @DISPID(3)
  @VTID(10)
  public abstract Date modifyDate();
  
  @DISPID(4)
  @VTID(11)
  public abstract IList items();
  
  @VTID(11)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object items(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IFileData
 * JD-Core Version:    0.7.0.1
 */