package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.Holder;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{6C66F3F1-52E8-4B39-840B-FB1C9800C676}")
public abstract interface IVCS
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String version();
  
  @DISPID(2)
  @VTID(8)
  public abstract boolean isCheckedOut();
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean isLocked();
  
  @DISPID(4)
  @VTID(10)
  public abstract void addObjectToVcs(@Optional @DefaultValue("1.1.1") String paramString1, @Optional @DefaultValue("Object Created in VCS") String paramString2);
  
  @DISPID(5)
  @VTID(11)
  public abstract void deleteObjectFromVCS();
  
  @DISPID(6)
  @VTID(12)
  public abstract void checkOut(String paramString1, String paramString2, boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2, @Optional @DefaultValue("-1") boolean paramBoolean3);
  
  @DISPID(7)
  @VTID(13)
  public abstract void checkIn(String paramString1, String paramString2, @Optional @DefaultValue("-1") boolean paramBoolean1, @Optional @DefaultValue("-1") boolean paramBoolean2);
  
  @DISPID(8)
  @VTID(14)
  public abstract void setCurrentVersion(String paramString);
  
  @DISPID(9)
  @VTID(15)
  public abstract void lockVcsObject();
  
  @DISPID(10)
  @VTID(16)
  public abstract void undoCheckout(boolean paramBoolean);
  
  @DISPID(11)
  @VTID(17)
  public abstract String currentVersion();
  
  @DISPID(12)
  @VTID(18)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject checkoutInfo();
  
  @DISPID(13)
  @VTID(19)
  public abstract IList versions();
  
  @VTID(19)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object versions(int paramInt);
  
  @DISPID(14)
  @VTID(20)
  public abstract String lockedBy();
  
  @DISPID(15)
  @VTID(21)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject versionInfo(String paramString);
  
  @DISPID(16)
  @VTID(22)
  public abstract void viewVersion(String paramString, Holder<String> paramHolder);
  
  @DISPID(17)
  @VTID(23)
  public abstract void clearView(@Optional @DefaultValue("") String paramString);
  
  @DISPID(18)
  @VTID(24)
  public abstract IList versionsEx();
  
  @VTID(24)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object versionsEx(int paramInt);
  
  @DISPID(19)
  @VTID(25)
  public abstract void refresh();
  
  @DISPID(20)
  @VTID(26)
  public abstract void checkInEx(String paramString1, String paramString2, @Optional @DefaultValue("-1") boolean paramBoolean1, @Optional @DefaultValue("-1") boolean paramBoolean2, @Optional @DefaultValue("0") boolean paramBoolean3, @Optional @DefaultValue("0") int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IVCS
 * JD-Core Version:    0.7.0.1
 */