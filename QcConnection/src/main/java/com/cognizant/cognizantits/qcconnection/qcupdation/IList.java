package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Iterator;

@IID("{F73CCC7B-05FA-4FD7-8FAA-B53DFFFE22DC}")
public abstract interface IList
  extends Com4jObject, Iterable<Com4jObject>
{
  @DISPID(1)
  @VTID(7)
  public abstract int count();
  
  @DISPID(2)
  @VTID(8)
  public abstract void add(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(3)
  @VTID(9)
  public abstract void remove(int paramInt);
  
  @DISPID(0)
  @VTID(10)
  @DefaultMethod
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object item(int paramInt);
  
  @DISPID(-4)
  @VTID(11)
  public abstract Iterator<Com4jObject> iterator();
  
  @DISPID(5)
  @VTID(12)
  public abstract void insert(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(6)
  @VTID(13)
  public abstract void swap(int paramInt1, int paramInt2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IList
 * JD-Core Version:    0.7.0.1
 */