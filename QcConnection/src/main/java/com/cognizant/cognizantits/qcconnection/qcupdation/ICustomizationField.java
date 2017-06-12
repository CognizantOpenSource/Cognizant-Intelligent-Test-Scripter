package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E34F74EC-DC52-42D8-A7E4-B4F06A56CF40}")
public abstract interface ICustomizationField
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String userLabel();
  
  @DISPID(1)
  @VTID(8)
  public abstract void userLabel(String paramString);
  
  @DISPID(2)
  @VTID(9)
  public abstract String tableName();
  
  @DISPID(3)
  @VTID(10)
  public abstract String editStyle();
  
  @DISPID(3)
  @VTID(11)
  public abstract void editStyle(String paramString);
  
  @DISPID(4)
  @VTID(12)
  public abstract boolean isSystem();
  
  @DISPID(4)
  @VTID(13)
  public abstract void isSystem(boolean paramBoolean);
  
  @DISPID(5)
  @VTID(14)
  public abstract boolean isCanFilter();
  
  @DISPID(5)
  @VTID(15)
  public abstract void isCanFilter(boolean paramBoolean);
  
  @DISPID(6)
  @VTID(16)
  public abstract boolean isKey();
  
  @DISPID(6)
  @VTID(17)
  public abstract void isKey(boolean paramBoolean);
  
  @DISPID(7)
  @VTID(18)
  public abstract int keyOrder();
  
  @DISPID(7)
  @VTID(19)
  public abstract void keyOrder(int paramInt);
  
  @DISPID(8)
  @VTID(20)
  public abstract boolean isActive();
  
  @DISPID(8)
  @VTID(21)
  public abstract void isActive(boolean paramBoolean);
  
  @DISPID(9)
  @VTID(22)
  public abstract boolean isEdit();
  
  @DISPID(9)
  @VTID(23)
  public abstract void isEdit(boolean paramBoolean);
  
  @DISPID(10)
  @VTID(24)
  public abstract boolean isHistory();
  
  @DISPID(10)
  @VTID(25)
  public abstract void isHistory(boolean paramBoolean);
  
  @DISPID(11)
  @VTID(26)
  public abstract boolean isMail();
  
  @DISPID(11)
  @VTID(27)
  public abstract void isMail(boolean paramBoolean);
  
  @DISPID(12)
  @VTID(28)
  public abstract boolean isVerify();
  
  @DISPID(12)
  @VTID(29)
  public abstract void isVerify(boolean paramBoolean);
  
  @DISPID(13)
  @VTID(30)
  public abstract boolean isByCode();
  
  @DISPID(13)
  @VTID(31)
  public abstract void isByCode(boolean paramBoolean);
  
  @DISPID(14)
  @VTID(32)
  public abstract boolean isRequired();
  
  @DISPID(14)
  @VTID(33)
  public abstract void isRequired(boolean paramBoolean);
  
  @DISPID(15)
  @VTID(34)
  public abstract String userColumnType();
  
  @DISPID(15)
  @VTID(35)
  public abstract void userColumnType(String paramString);
  
  @DISPID(16)
  @VTID(36)
  public abstract boolean isKeepValue();
  
  @DISPID(16)
  @VTID(37)
  public abstract void isKeepValue(boolean paramBoolean);
  
  @DISPID(17)
  @VTID(38)
  public abstract boolean isCustomizable();
  
  @DISPID(17)
  @VTID(39)
  public abstract void isCustomizable(boolean paramBoolean);
  
  @DISPID(18)
  @VTID(40)
  public abstract int fieldSize();
  
  @DISPID(18)
  @VTID(41)
  public abstract void fieldSize(int paramInt);
  
  @DISPID(19)
  @VTID(42)
  public abstract String columnName();
  
  @DISPID(20)
  @VTID(43)
  public abstract String columnType();
  
  @DISPID(20)
  @VTID(44)
  public abstract void columnType(String paramString);
  
  @DISPID(21)
  @VTID(45)
  public abstract String editMask();
  
  @DISPID(21)
  @VTID(46)
  public abstract void editMask(String paramString);
  
  @DISPID(22)
  @VTID(47)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject list();
  
  @DISPID(22)
  @VTID(48)
  public abstract void list(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(23)
  @VTID(49)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object rootId();
  
  @DISPID(23)
  @VTID(50)
  public abstract void rootId(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(24)
  @VTID(51)
  public abstract int type();
  
  @DISPID(24)
  @VTID(52)
  public abstract void type(int paramInt);
  
  @DISPID(25)
  @VTID(53)
  public abstract boolean updated();
  
  @DISPID(25)
  @VTID(54)
  public abstract void updated(boolean paramBoolean);
  
  @DISPID(26)
  @VTID(55)
  public abstract int grantModifyMask();
  
  @DISPID(26)
  @VTID(56)
  public abstract void grantModifyMask(int paramInt);
  
  @DISPID(27)
  @VTID(57)
  public abstract int ownerSensibleMask();
  
  @DISPID(27)
  @VTID(58)
  public abstract void ownerSensibleMask(int paramInt);
  
  @DISPID(28)
  @VTID(59)
  public abstract int isVisibleInNewBug();
  
  @DISPID(28)
  @VTID(60)
  public abstract void isVisibleInNewBug(int paramInt);
  
  @DISPID(29)
  @VTID(61)
  public abstract boolean isTransitionLogic();
  
  @DISPID(29)
  @VTID(62)
  public abstract void isTransitionLogic(boolean paramBoolean);
  
  @DISPID(30)
  @VTID(63)
  public abstract String defaultValue();
  
  @DISPID(30)
  @VTID(64)
  public abstract void defaultValue(String paramString);
  
  @DISPID(31)
  @VTID(65)
  public abstract boolean isToSum();
  
  @DISPID(31)
  @VTID(66)
  public abstract void isToSum(boolean paramBoolean);
  
  @DISPID(32)
  @VTID(67)
  public abstract int visibleForGroups();
  
  @DISPID(32)
  @VTID(68)
  public abstract void visibleForGroups(int paramInt);
  
  @DISPID(33)
  @VTID(69)
  public abstract boolean versionControl();
  
  @DISPID(33)
  @VTID(70)
  public abstract void versionControl(boolean paramBoolean);
  
  @DISPID(34)
  @VTID(71)
  public abstract boolean newCreated();
  
  @DISPID(34)
  @VTID(72)
  public abstract void newCreated(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationField
 * JD-Core Version:    0.7.0.1
 */