package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.Optional;
import com4j.VTID;

@IID("{51A589CA-B213-4D57-B7DA-BFA8C7F4CC81}")
public abstract interface IAssetRelationFactory
  extends IBaseFactoryEx
{
  @DISPID(9)
  @VTID(17)
  public abstract void removeRelations(boolean paramBoolean, @Optional @DefaultValue("-1") int paramInt, @Optional @DefaultValue("") String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAssetRelationFactory
 * JD-Core Version:    0.7.0.1
 */