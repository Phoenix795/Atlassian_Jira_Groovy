import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueManager

def issueManager = ComponentAccessor.issueManager
def issue = issueManager.getIssueObject("issue_key")

return [
Key:issue.key,
Project:issue.projectObject.getKey(),
Summary:issue.getSummary(),
Issuetype:issue.issueType.name,
AssigneeName:issue.assignee?.getDisplayName()?"not empty":"empty",
Status:issue.status.name
]
