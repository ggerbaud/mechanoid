package com.robotoworks.mechanoid.sqlite.naming;

import java.util.List;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.robotoworks.mechanoid.sqlite.sqliteModel.SelectSource;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SingleSourceTable;
import com.robotoworks.mechanoid.sqlite.sqliteModel.SqliteModelPackage;
import com.robotoworks.mechanoid.sqlite.sqliteModel.TableDefinition;

public class NameHelper {
	public static QualifiedName getName(SelectSource ele) {
		if(ele.getName() != null) {
			return QualifiedName.create(ele.getName());
		}
		
		if(ele instanceof SingleSourceTable) {
			List<INode> nodes = NodeModelUtils.findNodesForFeature(ele, SqliteModelPackage.Literals.SINGLE_SOURCE_TABLE__TABLE_REFERENCE);
			String tableName = NodeModelUtils.getTokenText(nodes.get(0));
			
			return QualifiedName.create(tableName);
		}
		
		return null;
	}
	
	public static QualifiedName getName(TableDefinition ele) {
		return QualifiedName.create(ele.getName());
	}
}
