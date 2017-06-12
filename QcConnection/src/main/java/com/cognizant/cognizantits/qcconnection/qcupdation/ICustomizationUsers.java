package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{DCFC6A77-C0F7-4F36-82E2-5164749254AF}")
public abstract interface ICustomizationUsers
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject user(String paramString);
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addUser(String paramString);
  
  @DISPID(3)
  @VTID(9)
  public abstract IList users();
  
  @VTID(9)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object users(int paramInt);
  
  @DISPID(4)
  @VTID(10)
  public abstract void removeUser(String paramString);
  
  @DISPID(5)
  @VTID(11)
  public abstract String domainUsers();
  
  @DISPID(6)
  @VTID(12)
  public abstract void addSiteUser(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(7)
  @VTID(13)
  public abstract String domainUsersWithoutProjectUsers();
  
  @DISPID(8)
  @VTID(14)
  public abstract void addSiteAuthenticatedUser(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, @MarshalAs(NativeType.VARIANT) Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationUsers
 * JD-Core Version:    0.7.0.1
 */