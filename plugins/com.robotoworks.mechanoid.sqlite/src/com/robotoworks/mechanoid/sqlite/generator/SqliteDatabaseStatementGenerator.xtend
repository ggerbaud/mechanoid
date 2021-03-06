package com.robotoworks.mechanoid.sqlite.generator

import com.google.inject.Inject
import com.robotoworks.mechanoid.sqlite.sqliteModel.DDLStatement
import java.util.Collection
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.serializer.ISerializer
import com.robotoworks.mechanoid.sqlite.sqliteModel.CreateTableStatement
import com.robotoworks.mechanoid.sqlite.sqliteModel.CreateViewStatement
import com.robotoworks.mechanoid.sqlite.sqliteModel.CreateTriggerStatement

class SqliteDatabaseStatementGenerator {
	@Inject extension ISerializer
	SaveOptions saveOptions
	
	new () {
		saveOptions = SaveOptions::newBuilder()
				.noValidation
				.options;
	}
	
	def generateStatements(Collection<DDLStatement> statements) '''
		�FOR stmt : statements�
		�generateStatement(stmt)�
		�ENDFOR�
	'''
	
	def generateTableStatements(Collection<CreateTableStatement> statements) '''
		�FOR stmt : statements�
		�generateStatement(stmt)�
		�ENDFOR�
	'''
	
	def generateViewStatements(Collection<CreateViewStatement> statements) '''
		�FOR stmt : statements�
		�generateStatement(stmt)�
		�ENDFOR�
	'''
	
	def generateTriggerStatements(Collection<CreateTriggerStatement> statements) '''
		�FOR stmt : statements�
		�generateStatement(stmt)�
		�ENDFOR�
	'''
	
	def generateStatement(DDLStatement stmt) '''
		db.execSQL(
			�FOR line : stmt.serialize(saveOptions).trim.split("\\r?\\n") SEPARATOR " +"�
			"�line.trim.replaceAll('\\\"', '\\\\\"')� "
			�ENDFOR�
		);	
	'''
}