package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{2FA7E440-704F-4EFE-B500-EB93E7AFD294}")
public abstract interface ICustomizationField2
  extends ICustomizationField
{
  @DISPID(35)
  @VTID(73)
  public abstract boolean grantModifyForGroup(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(35)
  @VTID(74)
  public abstract void grantModifyForGroup(@MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @DISPID(36)
  @VTID(75)
  public abstract IList authorizedModifyForGroups();
  
  @VTID(75)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object authorizedModifyForGroups(int paramInt);
  
  @DISPID(37)
  @VTID(76)
  public abstract boolean ownerSensibleForGroup(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(37)
  @VTID(77)
  public abstract void ownerSensibleForGroup(@MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @DISPID(38)
  @VTID(78)
  public abstract IList authorizedOwnerSensibleForGroups();
  
  @VTID(78)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object authorizedOwnerSensibleForGroups(int paramInt);
  
  @DISPID(39)
  @VTID(79)
  public abstract boolean visibleInNewBugForGroup(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(39)
  @VTID(80)
  public abstract void visibleInNewBugForGroup(@MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @DISPID(40)
  @VTID(81)
  public abstract IList authorizedVisibleInNewBugForGroups();
  
  @VTID(81)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object authorizedVisibleInNewBugForGroups(int paramInt);
  
  @DISPID(41)
  @VTID(82)
  public abstract boolean visibleForGroup(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(41)
  @VTID(83)
  public abstract void visibleForGroup(@MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @DISPID(42)
  @VTID(84)
  public abstract IList authorizedVisibleForGroups();
  
  @VTID(84)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object authorizedVisibleForGroups(int paramInt);
  
  @DISPID(43)
  @VTID(85)
  public abstract boolean isCanGroup();
  
  @DISPID(43)
  @VTID(86)
  public abstract void isCanGroup(boolean paramBoolean);
  
  @DISPID(44)
  @VTID(87)
  public abstract boolean auditUpdate();
  
  @DISPID(44)
  @VTID(88)
  public abstract void auditUpdate(boolean paramBoolean);
  
  @DISPID(45)
  @VTID(89)
  public abstract boolean isSearchable();
  
  @DISPID(45)
  @VTID(90)
  public abstract void isSearchable(boolean paramBoolean);
  
  @DISPID(46)
  @VTID(91)
  public abstract boolean canMakeSearchable();
  
  @DISPID(47)
  @VTID(92)
  public abstract boolean isVirtual();
  
  @DISPID(48)
  @VTID(93)
  public abstract boolean isMultiValue();
  
  @DISPID(48)
  @VTID(94)
  public abstract void isMultiValue(boolean paramBoolean);
  
  @DISPID(49)
  @VTID(95)
  public abstract boolean canMakeMultiValue();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationField2
 * JD-Core Version:    0.7.0.1
 */