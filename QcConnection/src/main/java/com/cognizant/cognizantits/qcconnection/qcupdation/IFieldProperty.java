package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{C2E1AF68-28C8-4DA3-8C65-5E1D230B1FF6}")
public abstract interface IFieldProperty
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  public abstract String userLabel();
  
  @DISPID(1)
  @VTID(8)
  public abstract String dbTableName();
  
  @DISPID(2)
  @VTID(9)
  public abstract String dbColumnName();
  
  @DISPID(3)
  @VTID(10)
  public abstract String dbColumnType();
  
  @DISPID(4)
  @VTID(11)
  public abstract String editStyle();
  
  @DISPID(5)
  @VTID(12)
  public abstract String editMask();
  
  @DISPID(6)
  @VTID(13)
  public abstract boolean isSystem();
  
  @DISPID(7)
  @VTID(14)
  public abstract boolean isCanFilter();
  
  @DISPID(8)
  @VTID(15)
  public abstract boolean isKey();
  
  @DISPID(9)
  @VTID(16)
  public abstract int keyOrder();
  
  @DISPID(10)
  @VTID(17)
  public abstract boolean isEdit();
  
  @DISPID(11)
  @VTID(18)
  public abstract boolean isActive();
  
  @DISPID(12)
  @VTID(19)
  public abstract boolean isHistory();
  
  @DISPID(13)
  @VTID(20)
  public abstract boolean isMail();
  
  @DISPID(14)
  @VTID(21)
  public abstract boolean isVerify();
  
  @DISPID(15)
  @VTID(22)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject root();
  
  @DISPID(16)
  @VTID(23)
  public abstract boolean isByCode();
  
  @DISPID(17)
  @VTID(24)
  public abstract boolean isRequired();
  
  @DISPID(18)
  @VTID(25)
  public abstract String userColumnType();
  
  @DISPID(19)
  @VTID(26)
  public abstract boolean isKeepValue();
  
  @DISPID(20)
  @VTID(27)
  public abstract boolean isCustomizable();
  
  @DISPID(21)
  @VTID(28)
  public abstract int fieldSize();
  
  @DISPID(22)
  @VTID(29)
  public abstract boolean isVisibleInNewBug();
  
  @DISPID(23)
  @VTID(30)
  public abstract boolean readOnly();
  
  @DISPID(24)
  @VTID(31)
  public abstract boolean isToSum();
  
  @DISPID(25)
  @VTID(32)
  public abstract boolean isModify();
  
  @DISPID(26)
  @VTID(33)
  public abstract boolean isVersionControl();
  
  @DISPID(27)
  @VTID(34)
  public abstract boolean isVisible();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IFieldProperty
 * JD-Core Version:    0.7.0.1
 */