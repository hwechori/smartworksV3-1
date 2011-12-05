
		select ctgInfo.parentCtgId
			, ctgInfo.parentCtg
			, ctgInfo.subCtgId
			, ctgInfo.subCtg
			, prcInst.prcObjId
			, prcInst.prcName
			, prcInst.prcCreateUser
			, prcInst.prcCreateDate
			, prcInst.prcModifyUser
			, prcInst.prcModifyDate
			, prcInst.prcStatus
			, prcInst.prcTitle
			, prcInst.prcDid
			, prcInst.prcPrcId
			, prcInstInfo.lastTask_tskprcinstid
			, prcInstInfo.lastTask_tskobjid
			, prcInstInfo.lastTask_tskname
			, prcInstInfo.lastTask_tskcreateuser
			, prcInstInfo.lastTask_tskcreateDate
			, prcInstInfo.lastTask_tskstatus
			, prcInstInfo.lastTask_tsktype
			, prcInstInfo.lastTask_tsktitle
			, prcInstInfo.lastTask_tskassignee
			, prcInstInfo.lastTask_tskexecuteDate
			, prcInstInfo.lastTask_tskduedate
			, prcInstInfo.lastTask_tskform
			, (select count(*) from tsktask where tskstatus='11' and tsktype='common' and tskprcInstId = prcInst.prcObjid) as lastTaskCount
		from 
			prcprcinst prcInst, 
			(
				select a.tskprcinstid as lastTask_tskprcinstid
						, task.tskobjid as lastTask_tskobjid
						, task.tskname as lastTask_tskname
						, task.tskcreateuser as lastTask_tskcreateuser
						, task.tskcreateDate as lastTask_tskcreateDate
						, task.tskstatus as lastTask_tskstatus
						, task.tsktype as lastTask_tsktype
						, task.tsktitle as lastTask_tsktitle
						, task.tskassignee as lastTask_tskassignee
						, task.tskexecuteDate as lastTask_tskexecuteDate
						, task.tskduedate as lastTask_tskduedate
						, task.tskform as lastTask_tskform
				from (
						select tskprcinstId , max(tskCreatedate) as createDate 
						from tsktask 
						where tsktype='common' 
						group by tskprcinstid
					  ) a,	
					  TskTask task		
				where 
					a.createDate = task.tskcreatedate
			) prcInstInfo,
 		    (
				select prcinst.prcobjid as prcinstid
						, parentCtg.id as parentCtgId
						, parentCtg.name as parentCtg
						, ctg.id as subCtgId
						, ctg.name as subCtg
				from prcprcinst prcinst, swpackage pkg , swcategory ctg, swcategory parentCtg
				where prcinst.prcdid = pkg.packageid
					and pkg.categoryid = ctg.id
					and ctg.parentid = parentCtg.id

		    ) ctgInfo	
		where 
			prcInst.prcobjid=prcInstInfo.lastTask_tskprcinstid
			and prcInst.prcobjid = ctginfo.prcinstid
			and prcInst.prcDid = :prcDid
			--and prcInst.prcobjid in ('402880eb33241bca0133250c67450003','402880eb338779f60133877cb9630003','5ef4e5632c779b42012d552587982e2d')
			
			
			
			
			
			
			
			
			
			
			
			
			
select myTask.tskname, prcInstInfo.*
from (
	select * 
	from tsktask
	where (tsktask.tskstatus='11' 
	and tsktask.tskassignee='pmkim@semiteq.co.kr')
	or 
	(
		tskTask.tskassignee='pmkim@semiteq.co.kr'
		and tskTask.isStartActivity = 'true'
	)	
) myTask
left outer join
(select  ctgInfo.parentCtgId
			, ctgInfo.parentCtg
			, ctgInfo.subCtgId
			, ctgInfo.subCtg 
			, info.*
from (
		select
			 prcInst.prcObjId
			, prcInst.prcName
			, prcInst.prcCreateUser
			, prcInst.prcCreateDate
			, prcInst.prcModifyUser
			, prcInst.prcModifyDate
			, prcInst.prcStatus
			, prcInst.prcTitle
			, prcInst.prcDid
			, prcInst.prcPrcId
			, prcInstInfo.lastTask_tskobjid
			, prcInstInfo.lastTask_tskname
			, prcInstInfo.lastTask_tskcreateuser
			, prcInstInfo.lastTask_tskcreateDate
			, prcInstInfo.lastTask_tskstatus
			, prcInstInfo.lastTask_tsktype
			, prcInstInfo.lastTask_tsktitle
			, prcInstInfo.lastTask_tskassignee
			, prcInstInfo.lastTask_tskexecuteDate
			, prcInstInfo.lastTask_tskduedate
			, prcInstInfo.lastTask_tskform
			, (select count(*) from tsktask where tskstatus='11' and tsktype='common' and tskprcInstId = prcInst.prcObjid) as lastTaskCount
		from 
			prcprcinst prcInst, 
			(
				select a.tskprcinstid as lastTask_tskprcinstid
						, task.tskobjid as lastTask_tskobjid
						, task.tskname as lastTask_tskname
						, task.tskcreateuser as lastTask_tskcreateuser
						, task.tskcreateDate as lastTask_tskcreateDate
						, task.tskstatus as lastTask_tskstatus
						, task.tsktype as lastTask_tsktype
						, task.tsktitle as lastTask_tsktitle
						, task.tskassignee as lastTask_tskassignee
						, task.tskexecuteDate as lastTask_tskexecuteDate
						, task.tskduedate as lastTask_tskduedate
						, task.tskform as lastTask_tskform
				from (
						select tskprcinstId , max(tskCreatedate) as createDate 
						from tsktask 
						where tsktype='common' 
						group by tskprcinstid
					  ) a,	
					  TskTask task		
				where 
					a.createDate = task.tskcreatedate
			) prcInstInfo	
		where
			prcInst.prcobjid=prcInstInfo.lastTask_tskprcinstid
			--and prcInst.prcobjid = '5ef4e5632bf04547012c16e998e305b7'

	) info
	left outer join
	(
		select prcinst.prcobjid as prcinstid
				, parentCtg.id as parentCtgId
				, parentCtg.name as parentCtg
				, ctg.id as subCtgId
				, ctg.name as subCtg
		from prcprcinst prcinst, swpackage pkg , swcategory ctg, swcategory parentCtg
		where prcinst.prcdid = pkg.packageid
			and pkg.categoryid = ctg.id
			and ctg.parentid = parentCtg.id
	) ctgInfo
	on info.prcobjid = ctginfo.prcinstid
) prcInstInfo
on mytask.tskprcinstid = prcInstInfo.prcObjId

