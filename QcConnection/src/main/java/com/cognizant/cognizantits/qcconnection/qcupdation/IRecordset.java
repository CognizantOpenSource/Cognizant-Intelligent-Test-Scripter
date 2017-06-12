package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{025854DA-9D81-40E8-853D-F4EA33073A77}")
public abstract interface IRecordset
  extends IColumnInfo
{
  @DISPID(0)
  @VTID(12)
  @DefaultMethod
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object fieldValue(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(0)
  @VTID(13)
  @DefaultMethod
  public abstract void fieldValue(@MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2);
  
  @DISPID(6)
  @VTID(14)
  public abstract int recordCount();
  
  @DISPID(7)
  @VTID(15)
  public abstract boolean bor();
  
  @DISPID(8)
  @VTID(16)
  public abstract boolean eor();
  
  @DISPID(9)
  @VTID(17)
  public abstract int cacheSize();
  
  @DISPID(9)
  @VTID(18)
  public abstract void cacheSize(int paramInt);
  
  @DISPID(10)
  @VTID(19)
  public abstract int position();
  
  @DISPID(10)
  @VTID(20)
  public abstract void position(int paramInt);
  
  @DISPID(11)
  @VTID(21)
  public abstract void first();
  
  @DISPID(12)
  @VTID(22)
  public abstract void next();
  
  @DISPID(13)
  @VTID(23)
  public abstract void prev();
  
  @DISPID(14)
  @VTID(24)
  public abstract void last();
  
  @DISPID(15)
  @VTID(25)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject clone();
  
  @DISPID(16)
  @VTID(26)
  public abstract void refresh(@Optional @DefaultValue("0") int paramInt1, @Optional int paramInt2, @Optional int paramInt3);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IRecordset
 * JD-Core Version:    0.7.0.1
 */