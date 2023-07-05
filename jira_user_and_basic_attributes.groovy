import com.atlassian.jira.component.ComponentAccessor

def user = ComponentAccessor.userManager.getUserByName("username")
def userProperties = ComponentAccessor.userPropertyManager.getPropertySet(user)

def propertyList = []
userProperties.getKeys().each{ propertyName ->
  if(propertyName.toString().contains("jira.meta")){
    def propertyValue = userProperties.getString(propertyName.toString())
    if(propertyValue){
      propertyList.add("${propertyName} - ${propertyValue}")
    }
  }
}

return propertyList.join("<br>")
